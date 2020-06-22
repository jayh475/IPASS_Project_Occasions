

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
        window.sessionStorage.setItem("myJWT", myJson.token);
        window.sessionStorage.setItem("myUsername", myJson.message);
        // document.getElementById("login-form").reset();

        showInlognaam();
    })
        .catch(error => console.log(error));

}


function showInlognaam() {
    let username = window.sessionStorage.getItem("myUsername");
    let cloneUsername = username.valueOf();

  // document.getElementById("showUsername").innerHTML = `Welkom ${cloneUsername} !`;
    document.getElementById("showUsername").innerHTML = `welkom ${cloneUsername}`;

}



function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
    document.getElementById("login-form").reset();
}

// function resetFormAfterLogin(){
//     formData.
//
// }




