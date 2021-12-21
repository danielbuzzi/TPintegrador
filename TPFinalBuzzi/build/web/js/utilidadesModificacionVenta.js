function existenCamposVacios() {

 
    var cliente = document.getElementById("cliente");
    var servicio = document.getElementById("servicio");
    var paquete = document.getElementById("paquete");
    var mediopago = document.getElementById('mediopago');


    if (mediopago.selectedIndex === 0 || cliente.selectedIndex === 0) {
        //|| cliente[0]
        confirm("Debe seleccionar  un medio pago o un cliente");
        return false;
    } else if (servicio.selectedIndex === 0 && paquete.selectedIndex === 0) {
        confirm("Debe seleccionar un servicio o un paquete");
        return false;
    } else {
        return true;
    }


}

function seleccionProducto() {

    var eleccion = document.getElementsByName("compra");
    var servicio = document.getElementById("servicio");
    var paquete = document.getElementById("paquete");
    if (eleccion[0].checked) {
        servicio.disabled = false;
        paquete.disabled = true;
        //paquete.selected[0]=true;
         //paquete.item(0).selected = 'selected';
           paquete.selectedIndex=0;

    } else {if(eleccion[1].checked){


        servicio.disabled = true;
        paquete.disabled = false;
        servicio.selectedIndex=0;
    }
    }

}
