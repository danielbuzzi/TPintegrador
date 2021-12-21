//Activa y desactiva la posibilidad de escoger un servicio o un paquete
//según la selección realizada

function seleccionProducto() {

    var eleccion = document.getElementsByName("compra");
    var servicio = document.getElementById("servicio");
    var paquete = document.getElementById("paquete");
    if (eleccion[0].checked) {
        servicio.disabled = false;
        paquete.disabled = true;
        //eleccion.value="0";
        //paquete.selectedIndex=0;
        paquete.value=0;
      
  
        

    } else {


        servicio.disabled = true;
        paquete.disabled = false;
        servicio.value =0;
    }


}
//Comprobacion que no existan campos vacios ( son olbigatorios 
//el cliente, medio de pago y al menos un serviocio o un paquete)


function existenCamposVacios() {

 
    var cliente = document.getElementById("cliente");
    var servicio = document.getElementById("servicio");
    var paquete = document.getElementById("paquete");
    var mediopago = document.getElementById('mediopago');


    if (mediopago.selectedIndex === 0 || cliente.selectedIndex === 0) {
        //|| cliente[0]
        confirm("Todos los datos deben ser cargados");
        return false;
    } else if (servicio.selectedIndex === 0 && paquete.selectedIndex === 0) {
        confirm("Todos los datos deben ser cargados");
        return false;
    } else {
        return true;
    }


}





