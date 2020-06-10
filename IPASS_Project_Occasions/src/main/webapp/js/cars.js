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

function getCarsByValue(){
    let carData;
    console.log("getcarsbyvalue");
    fetch("restservices/cars/"+document.getElementById("brand").value)
        .then(response => Promise.all([response.status, response.json()]))
        .then(function([status, myJson]){
            if(status >400){
                alert("geen resultaten gevonden")
            }else{

            console.log(myJson);
            carData = myJson;
            document.getElementById("gesorteerdeAutos").innerHTML = `
${carData.map(carTemplate).join('')}
`
        }})

}












