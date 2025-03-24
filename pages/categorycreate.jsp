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
<script src="js/categorycreate.js"></script>
<body >
<div id="alertContainer" class="fixed top-5 right-5 space-y-3"></div>
<div class="max-w-4xl p-6 mx-auto mt-20 bg-white rounded-md shadow-xl shadow-blue-300 dark:bg-gray-800">
  <h1 class="text-xl font-bold text-gray-600 capitalize dark:text-white">Adding new category</h1>
  <form onsubmit="createCategoryDashBoard()" id="categoryForm" method="post">
    <div class="grid grid-cols-1 gap-6 mt-4 sm:grid-cols-2">
      <div>
        <label class="text-gray-600 dark:text-gray-200" for="nameCategory">Name</label>
        <input name="categoryName" placeholder="Enter name..." id="nameCategory" type="text" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-300 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-500 dark:focus:border-blue-500 focus:outline-none focus:ring">
        <div id="nameError" class="hidden text-red-500">Name of category must be (a-z | A-Z)</div>
      </div>
      <div>
        <label class="text-gray-600 dark:text-gray-200" for="description">Description</label>
        <input name="categoryDescription" placeholder="Enter description..." id="description" type="text" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-300 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-500 dark:focus:border-blue-500 focus:outline-none focus:ring">
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
