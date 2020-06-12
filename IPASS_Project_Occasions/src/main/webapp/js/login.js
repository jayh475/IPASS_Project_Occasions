

function login() {
    let formData = new FormData(document.querySelector("#login-form"));
    let  encData = new URLSearchParams(formData.entries());


    fetch("restservices/authentication/login", {method: "POST", body: encData})
        .then(function (response) {
            if (response.ok) {
                alert("U bent succesvol ingelogd.");
                return response.json();


            } else {
               alert("inloggen is mislukt, verkeerde inloggegevens");
                console.log(response.status);
            }
        }).then(myJson => {
            // inlognaam();
        window.sessionStorage.setItem("myJWT", myJson.token)
    })
        .catch(error => console.log(error));

}

// function inlognaam() {
//     let token = window.sessionStorage.getItem("myJWT");
//     let username = token.message;
//     console.log(username);
//     document.querySelector("#username").textContent = username;
// }



function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}

// function resetFormAfterLogin(){
//     formData.
//
// }




