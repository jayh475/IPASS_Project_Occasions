

function login() {
    let formData = new FormData(document.querySelector("#login-form"));
    let  encData = new URLSearchParams(formData.entries());


    fetch("restservices/authentication/login", {method: "POST", body: encData})
        .then(function (response) {
            if (response.ok) {
                alert("U bent succesvol ingelogd.");
                window.location.reload();

                return response.json();


            } else {
               alert("inloggen is mislukt, verkeerde inloggegevens");
                console.log(response.status);
            }
        }).then(myJson => {
        window.sessionStorage.setItem("myJWT", myJson.token);
        window.sessionStorage.setItem("myUsername", myJson.message);
        console.log(myJson);
    })
        .catch(error => console.log(error));


    setLoginData();
}



function setLoginData() {
    console.log("voert uit");
    let isIngelogd = window.sessionStorage.getItem("myUsername");
    if(isIngelogd !== null) {
        
        document.getElementById("showUsername").innerHTML = `welkom ${isIngelogd}`;
        //alle elementen in de arraylist laten zien bij het inloggen.
        let x = document.getElementsByClassName("verberg");
        let i;
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "block";
        }

    }

}




function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
    document.getElementById("login-form").reset();
}





