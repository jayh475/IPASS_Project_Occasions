const registerbutton = document.getElementById("register-form-submit");


const password = document.getElementById("password");
const passwordRepeat = document.getElementById("psw-repeat");

registerbutton.addEventListener("click", (e) => {
    e.preventDefault();
    let formData = new FormData(document.querySelector("#register-form"));
    let encData = new URLSearchParams(formData.entries());

    if(password.innerText !== passwordRepeat.innerText ){
        alert("wachtwoorden komen niet overeen");
    }
    fetch("restservices/authentication/register", {method: "POST", body: encData})
        .then(function (response) {
            if (response.ok) {
                console.log(encData);
                alert("u heeft succesvol een account aangemaakt.");
                location.reload();
                location.replace("login.html");
                return  response.json();

            } else {
                alert("er is iets mis gegaan")
            }
        }).then(myJson => window.sessionStorage.setItem("myJWT", myJson.token)
        .catch(error => console.log(error)));
});