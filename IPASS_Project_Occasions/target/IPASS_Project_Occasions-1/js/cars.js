function carTemplate(car) {
    console.log("auto's worden weergegeven");
    return `
<div class="car">
    <img class="car-photo" src="${car.imageUrl}" alt="Auto foto's">
    <h4 class="car-name">${car.name}  </h4>
    <p><strong>merk:</strong>${car.brand} <strong> , model:</strong>${car.model}</p>
    <p><strong>prijs:€</strong>${car.price}  <strong> , bouwjaar:</strong>${car.yearOfManufacture}</p>
    <p><strong>km-stand:</strong> ${car.kilometre} <strong> , kenteken:</strong>${car.licencePlate}</p>
    <p><strong>brandstof:</strong>${car.fuelType}</p>
  

</div> `
}

function getCarsByValue() {
    let carData;
    console.log("getcarsbyvalue");
    fetch("restservices/cars/" + document.getElementById("brand").value)
        .then(response => Promise.all([response.status, response.json()]))
        .then(function ([status, myJson]) {
            if (status > 400) {
                alert("geen resultaten gevonden")
            } else {

                console.log(myJson);
                carData = myJson;
                document.getElementById("gesorteerdeAutos").innerHTML = `
${carData.map(carTemplate).join('')}
`
            }
        })

}


function createCar() {
    var formData = new FormData(document.querySelector("#POSTcar"));
    var encData = new URLSearchParams(formData.entries());
    var fetchOptions = {
        method: "POST",
        headers: {"Authorization": "Bearer " + window.sessionStorage.getItem("myJWT")},
        body: encData
    };

    fetch("restservices/car/createCar", fetchOptions)
        .then(function (response) {
            if (response.ok) {
                alert("Auto is aangemaakt!");
                window.location.reload();
                console.log(response);
            } else if (response.status === 404) {
                alert("auto bestaat al/ voer alle velden in");
            }else if(response.status === 403){
                alert("Niet ingelogd als admin");
            } else {
                console.log("er is iets anders miss gegaan");
            }

        })
}


function deleteCar() {
    const licencePlate = document.querySelector("#kenteken").value;
    console.log(licencePlate);
    let fetchOptions = {
        method: "DELETE",
        headers: {
            "Authorization": "Bearer " + window.sessionStorage.getItem("myJWT")
        },
    };

    fetch("restservices/car/" + licencePlate, fetchOptions)
        .then(function (response) {
            if (response.ok) {
                alert("auto is verwijderd!");
                window.location.reload();
                return response.json();
            } else if (response.status === 404) {
                alert("auto niet gevonden!");
            } else if( response.status ===403){
                alert("Niet ingelogd als admin");
            }
             else {
                console.log(response.json());

                console.log("er is iets anders miss gegaan");
            }

        })

}
function updateCar() {
    let carLicencePlate = document.querySelector("#licencePlateFound").value;
    let formData = new FormData(document.querySelector("#PATCHCars"));
    let encData = new URLSearchParams(formData.entries());
    let fetchOptions = {
        method: "PATCH",
        headers: {
            "Authorization": "Bearer " + window.sessionStorage.getItem("myJWT")
        },
        body: encData
    };

    fetch("restservices/car/editCar/" + carLicencePlate, fetchOptions)
        .then(function (response) {
            console.log(response.json());
            if (response.ok) {
                alert("auto is geupdate!");
                window.location.reload();
                return response.json();
            } else if (response.status === 404) {
                alert("auto niet gevonden of je hebt niet alles in gevuld!");
            } else if(response.status === 403){
                alert("Niet ingelogd als admin");
            }else{
                console.log("er is iets anders miss gegaan");
            }


        })
}








// open forms
function openFormCreateCar() {
    document.getElementById("createCar").style.display = "block";
}
function openFormDeleteCar() {
    document.getElementById("deleteCar").style.display = "block";
}
function openFormEditCar(){
    document.getElementById("editCar").style.display = "block";
}

//close forms
function closeCreateCar() {
    document.getElementById("createCar").style.display = "none";
    document.getElementById("POSTcar").reset();
}

function closeDeleteCar() {
    document.getElementById("deleteCar").style.display = "none";
    document.getElementById("deleteCarFormData").reset();
}
function closeEditCar(){
    document.getElementById("editCar").style.display = "none";
    document.getElementById("PATCHCars").reset();


}




















