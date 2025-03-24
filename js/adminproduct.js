function removeProduct(productId){
    window.location.href = `/removeProductsDashBoard?productId=${productId}`;
}

function forwardToProductEdition(productId){
    window.location.href = `/updateProductDashBoard?productId=${productId}`;
}

function forwardToProductCreation(){
    window.location.href = '/createProductsInfo'
}