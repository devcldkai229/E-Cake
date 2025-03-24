function createCategoryDashBoard(){
    let name = document.getElementsByName("nameCategory").value;

    let isFlag = true;

    document.getElementById("nameError").classList.add("hidden");
    if(/^[A-Za-z0-9_\-\s]+$/.test(name)){
        document.getElementById("nameError").classList.remove("hidden");
        isFlag = false;
    }

    if(isFlag){
        fetch(`/createCategoryDashBoard`, {
            method: "POST",
            body: new FormData(document.getElementById("categoryForm"))
        }).then(data => {
                showAlert("Create new category", "green");
                document.getElementById("categoryForm").reset();
            }
        ).catch(error => {
            showAlert("Failed to create category", "red");
            }
        )
    } else {
        showAlert("Invalid input, please check again!", "yellow");
    }
}
