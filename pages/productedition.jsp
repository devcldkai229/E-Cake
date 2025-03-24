<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Kaicourses | Admin Dashboard</title>
  <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">  <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
  <style>
    html {
      background-image: url('img/backgroundLandingpage.jpg');
      background-size: cover;
      background-repeat: no-repeat;
    }
  </style>
</head>
<script>
  function onChangeFileName(){
    const fileName = this.files.length > 0 ? this.files[0].name : 'No file chosen';
    document.getElementById('fileName').textContent = fileName;
  }
</script>
<body >
<div class="max-w-4xl p-6 mx-auto mt-20 bg-white rounded-md shadow-xl shadow-blue-300 dark:bg-gray-800">
  <h1 class="text-xl font-bold text-gray-600 capitalize dark:text-white">Product edition</h1>
  <form action="/updateEntireProducts" id="productForm" enctype="multipart/form-data" method="post">
    <input name="productId" type="hidden" value="${productEdition.getId()}">
    <div class="grid grid-cols-1 gap-6 mt-4 sm:grid-cols-2">
      <div>
        <label class="text-gray-600 dark:text-gray-200" for="nameProducts">Name</label>
        <input name="nameServlet" placeholder="${productEdition.getName()}" value="${productEdition.getName()}" id="nameProducts" type="text" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-300 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-500 dark:focus:border-blue-500 focus:outline-none focus:ring">
        <div id="nameError" class="hidden text-red-500">Name of product must be (a-z | A-Z)</div>
      </div>
      <div>
        <label class="text-gray-600 dark:text-gray-200" for="description">Description</label>
        <input name="descriptionServlet" value="${productEdition.getDescription()}" placeholder="${productEdition.getDescription()}" id="description" type="text" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-300 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-500 dark:focus:border-blue-500 focus:outline-none focus:ring">
      </div>
      <div>
        <label class="text-gray-600 dark:text-gray-200" for="unitsOfStocks">Units Of Stocks</label>
        <input name="quantityServlet" placeholder="${productEdition.getQuantity()}" value="${productEdition.getQuantity()}" id="unitsOfStocks" type="number" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-300 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-500 dark:focus:border-blue-500 focus:outline-none focus:ring">
        <div id="unitsOfStocksError" class="hidden text-red-500">Quantity must be at least 1</div>
      </div>
      <div>
        <label class="text-gray-600 dark:text-gray-200" for="price">Unit Price ($)</label>
        <input name="priceServlet" placeholder="${productEdition.getPrice()}" value="${productEdition.getPrice()}" id="price" type="number" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-300 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-500 dark:focus:border-blue-500 focus:outline-none focus:ring">
        <div id="priceError" class="hidden text-red-500">Price must be at least 0.01</div>
      </div>
      <div>
        <label class="text-gray-600 dark:text-gray-200">Categories</label>
        <select name="categoriesSelect" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-300 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-500 dark:focus:border-blue-500 focus:outline-none focus:ring">
          <c:forEach var="item" items="${categories}">
            <option value="${item.getId()}" ${item.getId() == productEdition.getCategoryId() ? 'selected' : ''}>
                ${item.getName()}
            </option>
          </c:forEach>
        </select>
        <input name="categoriesDefaultValue" type="hidden" value="${productEdition.getCategoryId()}">
      </div>
      <div>
        <label class="text-gray-600 dark:text-gray-200">Providers</label>
        <select name="suppliersSelect" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-300 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-500 dark:focus:border-blue-500 focus:outline-none focus:ring">
          <c:forEach var="item" items="${suppliers}">
            <option value="${item.getId()}" ${item.getId() == productEdition.getSupplierId() ? 'selected' : ''}>
                ${item.getCompanyName()}
            </option>
          </c:forEach>
        </select>
        <input name="suppliersDefaultValue" type="hidden" value="${productEdition.getSupplierId()}">
      </div>
      <div class="bg-white text-[#333] flex items-center shadow-[0_2px_10px_-3px_rgba(6,81,237,0.3)] p-1 min-w-[300px] w-max font-[sans-serif] rounded-md overflow-hidden my-7 mx-auto">
        <div class="flex px-4">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 612.675 612.675">
            <path d="M581.209 223.007 269.839 530.92c-51.592 51.024-135.247 51.024-186.839 0-51.592-51.023-51.592-133.737 0-184.761L363.248 69.04c34.402-34.009 90.15-34.009 124.553 0 34.402 34.008 34.402 89.166 0 123.174l-280.249 277.12c-17.19 17.016-45.075 17.016-62.287 0-17.19-16.993-17.19-44.571 0-61.587L394.37 161.42l-31.144-30.793-249.082 246.348c-34.402 34.009-34.402 89.166 0 123.174 34.402 34.009 90.15 34.009 124.552 0l280.249-277.12c51.592-51.023 51.592-133.737 0-184.761-51.593-51.023-135.247-51.023-186.839 0L36.285 330.784l1.072 1.071c-53.736 68.323-49.012 167.091 14.5 229.88 63.512 62.79 163.35 67.492 232.46 14.325l1.072 1.072 326.942-323.31-31.122-30.815z" data-original="#000000" />
          </svg>
          <p class="ml-3 text-sm" id="fileName">${productEdition.getProductImgUrl()}</p>
        </div>
        <label for="uploadFile" class="bg-gray-800 hover:bg-gray-700 text-white text-sm px-3 py-2.5 outline-none rounded-md cursor-pointer ml-auto w-max block">Upload</label>
        <input onchange="onChangeFileName()" name="fileServlet" type="file" id="uploadFile" class="hidden"/>
      </div>
    </div>

    <div class="flex justify-end mt-6">
      <button type="submit" class="px-8 py-4 leading-5 text-white transition-colors duration-200 transform bg-gray-600 rounded-md hover:bg-gray-900 hover:text-white hover:border-gray-900 focus:outline-none focus:bg-gray-600">Save</button>
    </div>
  </form>
</div>
<div class="flex items-center justify-center mt-6 text-indigo-500">
  <a href="/adminproductslist" class="flex items-center hover:text-indigo-700 hover:italic " href=""><ion-icon class="px-2 text-xl " name="arrow-back-sharp"></ion-icon><h3>Cancel</h3></a>
</div>
</body>
</html>
