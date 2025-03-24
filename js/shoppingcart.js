function updateFinalPriceWithShippingFee() {
    const shippingFeeFormal = parseFloat(document.querySelector('select[name="shippingTypes"]').value) || 0;

    const totalElement = document.getElementById("total").textContent.replace('$', '');
    const total = parseFloat(totalElement) || 0;

    document.getElementById("shippingfee").textContent = `$${shippingFeeFormal}`;

    document.getElementById("finaltotal").textContent = `$${(total + shippingFeeFormal)}`;

    document.getElementById("hiddenFinalTotal").value = document.getElementById("finaltotal").textContent.replace("$", "");
    document.getElementById("hiddenShippingFee").value = document.getElementById("shippingfee").textContent.replace("$", "")
}

function  updateLinkToOrder(event){
    let finalTotal = document.getElementById("hiddenFinalTotal").value;
    let shippingFee = parseFloat(document.getElementById("hiddenShippingFee").value);
    var form = document.getElementById("orderForm");
    form.action = '/orders?finalTotal='+finalTotal+'$shippingFee='+shippingFee;
}




