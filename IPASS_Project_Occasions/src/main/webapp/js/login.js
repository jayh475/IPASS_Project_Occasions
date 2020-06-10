function login() {
    let loginErrorMsg = document.getElementById("login-error-msg");
    let formData = new FormData(document.querySelector("#login-form"));
    let encData = new URLSearchParams(formData.entries());


    fetch("restservices/authentication/login", {method: "POST", body: encData})
        .then(function (response) {
            if (response.ok) {
                alert("U bent succesvol ingelogd.");
                location.replace("admin.html");
                return response.json();


            } else {
                loginErrorMsg.style.opacity = 1;
                console.log(response.status);
            }
        }).then(myJson => {
            inlognaam();
        window.sessionStorage.setItem("myJWT", myJson.token)
    })
        .catch(error => console.log(error));

}

function inlognaam() {
    let token = window.sessionStorage.getItem("myJWT");
    let username = token.message;
    console.log(username);
    document.querySelector("#username").textContent = username;

}




