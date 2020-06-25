function registreren(){
    let  formData = new FormData(document.querySelector("#register-form"));
    let encData = new URLSearchParams(formData.entries());
    console.log(encData.toString());


    let fetchOptions = {
        method: "POST",
        headers: {"Authorization": "Bearer " + window.sessionStorage.getItem("myJWT")},
        body: encData
    };

    fetch("restservices/authentication/register",  fetchOptions)
        .then(function (response) {
            if (response.ok) {
                alert("u heeft succesvol een account aangemaakt.");
                // location.replace("login.html");
                return  response.json();

            } else {
                alert("er is iets mis gegaan")
            }
        }).then(myJson => {
        window.sessionStorage.setItem("myJWT", myJson.token);

    })
        .catch(error => console.log(error));


}


function showNewUserName() {
    let username = window.sessionStorage.getItem("newUser");
    alert(username.toString());

}