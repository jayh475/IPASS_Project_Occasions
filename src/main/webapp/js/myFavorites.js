function myFavoritesTemplate(car) {
    console.log("auto's worden weergegeven");
    return `
<div class="car">
    <img class="car-photo" src="${car.imageUrl}" alt="Auto foto's">
     <input type="button"   onclick="deleteFavoriteCar(event)"  value=${car.licencePlate} class="car-unfavorite-button" </input>

    <h4 class="car-name">${car.name} </h4>
    <p><strong>merk:</strong>${car.brand} <strong> , model:</strong>${car.model}</p>
    <p><strong>prijs:€</strong>${car.price}  <strong> , bouwjaar:</strong>${car.yearOfManufacture}</p>
    <p><strong>km-stand:</strong> ${car.kilometre} <strong> , kenteken:</strong>${car.licencePlate}</p>
    <p><strong>brandstof:</strong>${car.fuelType}</p>
  

</div> `
}

function deleteFavoriteCar(event){
    console.log(event.target.value);
    let licencePlate=  event.target.value;


    let fetchOptions = {
        method: "DELETE",
        headers: {"Authorization": "Bearer " + window.sessionStorage.getItem("myJWT")}
    };

    fetch("restservices/account/deleteFavoriteCar/" + licencePlate, fetchOptions)
        .then(function (response) {
            if (response.ok) {
                alert("auto is verwijderd uit lijst met favorieten!");
                window.location.reload();
                return response.json();
            } else if (response.status === 404) {
                alert("auto niet gevonden");
            } else if( response.status ===403){
                alert("Niet ingelogd als admin");
            }
            else {
                console.log(response.json());
                console.log("er is iets anders miss gegaan");
            }

        });


}
