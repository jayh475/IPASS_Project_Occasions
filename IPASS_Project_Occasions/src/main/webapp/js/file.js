function carTemplate(car) {
    return `
<div class="car">
    <img class="car-photo" src="${car.imageUrl}" alt="Auto foto's">
    <h4 class="car-name">${car.name}   </h4>
    <p><strong>merk:</strong>${car.brand} <strong> ,model:</strong>${car.model}</p>
    <p><strong>prijs:€</strong>${car.price}  <strong> ,bouwjaar:</strong>${car.yearOfManufacture}</p>
    <p><strong>km-stand:</strong> ${car.kilometre}</p>
    <p><strong>kenteken:</strong>${car.licencePlate}</p>
    <p><strong>brandstof:</strong>${car.fuelType}</p>

</div> `
        }

