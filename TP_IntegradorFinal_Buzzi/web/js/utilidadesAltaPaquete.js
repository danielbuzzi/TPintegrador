// Funcion pata agregar servicios a la grilla de servicios del paquete (Alta del paquete)
//Variable general para el precio total del paquete
var total;
var filaServicioAgregado;

// Completamos la grilla de servicios para el paquete
function agregarServicio(idservicio, fila, btn) {
// var table = document.getElementById(id);
// var t2=document.getElementById(id)
//  var t1 =document.getElementById(id1)    ;
//alert(t1.rows[1].cells[1].value);

    var tbody = document.getElementById("tbd1");
    //alert(document.getElementById(id1).tbody.rows[0].cells[0].innerHTML);
    //alert(tbody.rows[0].cells[1].innerHTML);
    var t2 = document.getElementById("tablaservicioagregado");
    var tbody2 = document.getElementById("tbd2");


     //Aseguramos que no se seleccionen servicios repetidos
     
     if (buscarRepetido(fila) === true) {
     alert("El servicio elegido ya ha sido seleccionado previamente");
     return;
     }
     
     // No permito cargar mas de 3 servicios por paquete
     
     if(t2.rows.length ===4){
         alert("No se permite agregar mas de 3 servicios");
         return;
     }
     
   if (verificarDestinoServicio(fila) === true) {
        alert("Debe seleccionar servicios que tengan el mismo destino");
        return;
    }

    //verificarDestinoServicio(fila);
    //return;

    var row1 = document.createElement("TR");
    //row1.height = 110;
    //for(var i=0;i<3;i++){




    var col1 = document.createElement("TD");
    col1.setAttribute("name", "columnaid");
    let ids = document.createElement('input');
    ids.setAttribute("type", "text");
    ids.setAttribute("class", "input-no-borde");
    ids.setAttribute("name", "ids");

    ids.setAttribute("maxLength", "8");
    ids.setAttribute("size", "8");
    ids.setAttribute("value", tbody.rows[fila].cells[0].textContent);

    ids.setAttribute("readonly", "true");
    //ids.textContent = tbody.rows[fila].cells[4].innerHTML;
    col1.appendChild(ids);

    row1.appendChild(col1);
    tbody2.appendChild(row1);
    t2.appendChild(tbody2);

    var col2 = document.createElement("TD");
    let nombre = document.createElement('input');
    nombre.setAttribute("type", "text");
    nombre.setAttribute("class", "input-no-borde");
    nombre.setAttribute("name", "nombre");
    //costo.setAttribute("id","nombre"+element._id);
    nombre.setAttribute("maxLength", "25");
    nombre.setAttribute("size", "20");
    nombre.setAttribute("value", tbody.rows[fila].cells[1].innerHTML);
    nombre.setAttribute("readonly", "true");
    col2.appendChild(nombre);
    //col1.innerHTML = t1.rows[0].cells[0].innerHTML;
    //  col1.innerHTML = tbody.rows[fila].cells[0].innerHTML;
    row1.appendChild(col2);
    tbody2.appendChild(row1);
    t2.appendChild(tbody2);

    var col3 = document.createElement("TD");
    let destino = document.createElement('input');
    destino.setAttribute("type", "text");
    destino.setAttribute("class", "input-no-borde");
    destino.setAttribute("name", "destino");
    //costo.setAttribute("id","nombre"+element._id);
    destino.setAttribute("maxLength", "25");
    destino.setAttribute("size", "20");
    destino.setAttribute("value", tbody.rows[fila].cells[2].innerHTML);
    destino.setAttribute("readonly", "true");
    col3.appendChild(destino);


    row1.appendChild(col3);
    tbody2.appendChild(row1);
    t2.appendChild(tbody2);

    var col4 = document.createElement("TD");
    let fecha = document.createElement('input');
    fecha.setAttribute("type", "text");
    fecha.setAttribute("class", "input-no-borde");
    fecha.setAttribute("name", "fecha");
    //costo.setAttribute("id","nombre"+element._id);
    fecha.setAttribute("maxLength", "11");
    fecha.setAttribute("size", "11");
    fecha.setAttribute("value", tbody.rows[fila].cells[3].innerHTML);
    fecha.setAttribute("readonly", "true");
    col4.appendChild(fecha);
    // col3.innerHTML = tbody.rows[fila].cells[2].innerHTML;
    row1.appendChild(col4);
    tbody2.appendChild(row1);
    t2.appendChild(tbody2);
    //var col4 = document.createElement("TD");
    var col5 = document.createElement("TD");
    // var costo= tbody.rows[fila].cells[3].innerHTML;
    let costo = document.createElement('input');
    costo.setAttribute("type", "text");
    costo.setAttribute("class", "input-no-borde");
    costo.setAttribute("name", "costo");
    //costo.setAttribute("id","nombre"+element._id);
    costo.setAttribute("maxLength", "10");
    costo.setAttribute("size", "10");
    costo.setAttribute("value", tbody.rows[fila].cells[4].innerHTML);
    costo.setAttribute("readonly", "true");
    //costo.setAttribute("innerText",tbody.rows[fila].cells[3].innerHTML);
    costo.textContent = tbody.rows[fila].cells[4].innerHTML;
    col5.appendChild(costo);


    row1.appendChild(col5);
    tbody2.appendChild(row1);
    t2.appendChild(tbody2);




    var col6 = document.createElement("TD");
    let descripcionB = document.createElement('input');
    descripcionB.setAttribute("type", "text");
    descripcionB.setAttribute("class", "input-no-borde");
    descripcionB.setAttribute("name", "descripcionBreve");
    //costo.setAttribute("id","nombre"+element._id);
    descripcionB.setAttribute("maxLength", "8");
    descripcionB.setAttribute("size", "8");
    descripcionB.setAttribute("value", tbody.rows[fila].cells[5].innerHTML);
    descripcionB.setAttribute("readonly", "true");
    col6.appendChild(descripcionB);

    row1.appendChild(col6);
    tbody2.appendChild(row1);
    t2.appendChild(tbody2);

    var col7 = document.createElement("TD");
    let quitarelemento = document.createElement('input');
    quitarelemento.setAttribute("type", "button");
    quitarelemento.setAttribute("value", "Quitar");
    quitarelemento.setAttribute("name", "quitarservicio");
    quitarelemento.setAttribute("class", "btn-warning");
    //quitarelemento.onclick ="quitarElemento()";
    quitarelemento.setAttribute("onclick", "quitarElemento(this)");
    col7.appendChild(quitarelemento);
    row1.appendChild(col7);
    tbody2.appendChild(row1);
    t2.appendChild(tbody2);



// llamada a la funcion que calculta el precio total para el paquete
    calculoTotalPaquete();
    //quitarElementoServ(btn);



}



//Calculamos del precio total del paquete
function calculoTotalPaquete() {
    var costopaquete = document.getElementById("costopaquete");
    total = parseFloat(costopaquete.value);

    let totalcito;

    var costos = document.getElementsByName("costo");

    // Asignamos precio al paquete inclyendo un 10 por ciento de descuento
    totalcito = (parseFloat(total) + parseFloat(costos[costos.length - 1].value)).toFixed(2);
    //totalcito = totalcito - (totalcito * 0.10);

    //  var tot=totalcito.toString();
    //tot.replace(",",".");
    costopaquete.value = parseFloat(totalcito).toFixed(2);
}

//Comprobamos que se haya seleccionado al menos un servicio turistico 

function grillaVacia() {


    var oRows = document.getElementById('tablaservicioagregado').getElementsByTagName('tr');
    var iRowCount = oRows.length;
    if (iRowCount <= 1) {
        confirm("Debe agregar al menos un servicio turístico");


        return false;
    } else {
        return true;
    }
}


//Quitamos la fila correspondiente al elemento seleccionado 
//de la lista de servicios seleccionados

function quitarElemento(btn) {

    var row = btn.parentNode.parentNode;
    var costopaquete = document.getElementById("costopaquete");
    total = parseFloat(costopaquete.value);

    let totalcito;


    var valorfila = row.children[4].textContent;

    totalcito = Math.abs((parseFloat(total) - parseFloat(valorfila)).toFixed(2));

    costopaquete.value = parseFloat(totalcito).toFixed(2);


    row.remove();


}




function quitarElementoServ(btn) {

    var row = btn.parentNode.parentNode;


    row.remove();


}

//Averiguamos si el servicio elegido ya fue añadido a la lista de 
// servicios elegidos

function buscarRepetido(fila, btn) {
    var tbody = document.getElementById("tbd1");
    var buscar = tbody.rows[fila].cells[0].textContent;
    //alert("fila" + fila);
    //alert(buscar);
    var comparar = "";
    var encontrado = false;
    var celda;
    var t2 = document.getElementById("tablaservicioagregado");


    for (let i = 1; i < t2.rows.length; i++) {

        celda = t2.rows[i].getElementsByTagName('td');
        comparar = celda[0].children[0].value;

        if (comparar === buscar) {

            encontrado = true;

        }

    }
    return encontrado;
}
//Verificamos que solo pueda agregarse servicios 
// con el mismo destino

function verificarDestinoServicio(fila, btn) {

   var tbody = document.getElementById("tbd1");
    var buscar = tbody.rows[fila].cells[2].textContent;
    //alert("fila" + fila);
    //alert(buscar);
    var comparar = "";
    var encontrado = false;
    var celda;
    var t2 = document.getElementById("tablaservicioagregado");


    for (let i = 1; i < t2.rows.length; i++) {

        celda = t2.rows[i].getElementsByTagName('td');
        comparar = celda[2].children[0].value;

        if (comparar !== buscar) {

            encontrado = true;

        }

    }
    return encontrado;
}

function asignarTotal(){
    var t2 = document.getElementById("tablaservicioagregado");
     var costopaquete = document.getElementById("costopaquete");
    //total = parseFloat(costopaquete.value);
    var celda;
    let totalcito=0;


 


    
    for (let i = 1; i < t2.rows.length; i++) {

        celda = t2.rows[i].getElementsByTagName('td');
        totalcito = parseFloat(totalcito)+ parseFloat(celda[4].children[0].value);
        //alert(celda[4].children[0].value);
        costopaquete.value=parseFloat(totalcito).toFixed(2);

    }

    
    
}


function doSearch()

{

    const tableReg = document.getElementById('datos');

    const searchText = document.getElementById('searchTerm').value.toLowerCase();

    let total = 0;



    // Recorremos todas las filas con contenido de la tabla

    for (let i = 1; i < tableReg.rows.length; i++) {

        // Si el td tiene la clase "noSearch" no se busca en su cntenido

        if (tableReg.rows[i].classList.contains("noSearch")) {

            continue;

        }



        let found = false;

        const cellsOfRow = tableReg.rows[i].getElementsByTagName('td');

        // Recorremos todas las celdas

        for (let j = 0; j < cellsOfRow.length && !found; j++) {

            const compareWith = cellsOfRow[j].innerHTML.toLowerCase();

            // Buscamos el texto en el contenido de la celda

            if (searchText.length == 0 || compareWith.indexOf(searchText) > -1) {

                found = true;

                total++;

            }

        }

        if (found) {

            tableReg.rows[i].style.display = '';

        } else {

            // si no ha encontrado ninguna coincidencia, esconde la

            // fila de la tabla

            tableReg.rows[i].style.display = 'none';

        }

    }



    // mostramos las coincidencias

    const lastTR = tableReg.rows[tableReg.rows.length - 1];

    const td = lastTR.querySelector("td");

    lastTR.classList.remove("hide", "red");

    if (searchText == "") {

        lastTR.classList.add("hide");

    } else if (total) {

        td.innerHTML = "Se ha encontrado " + total + " coincidencia" + ((total > 1) ? "s" : "");

    } else {

        lastTR.classList.add("red");

        td.innerHTML = "No se han encontrado coincidencias";

    }

}