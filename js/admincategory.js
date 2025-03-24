function removeCategory(categoryId){
    fetch(`/removeCategoriesDashBoard?categoryId=${categoryId}`, {
        method: 'POST'
        }).then(response => response.json())
        .then(data => {
            if(data.success){
                document.getElementById(`category-row-${categoryId}`).remove();
                let totalCategoriesBefore = parseInt(document.getElementById("totalCategories").innerText);
                let totalCategoriesAfter = totalCategoriesBefore - 1;
                document.getElementById("totalCategories").innerText = totalCategoriesAfter;
            } else {
                document.getElementById(`messageRemoveError-${categoryId}`).innerText = data.message;
                document.getElementById(`messageRemoveError-${categoryId}`).classList.remove("hidden");
            }
        })
        .catch(error => console.error("Error:", error));
}


function forwardToCategoryCreation(){
    window.location.href = '/categorycreate.jsp'
}