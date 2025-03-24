<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <link href="css/marketplace.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="/img/phonex_logo_prev_ui.png">
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Inconsolata:wght@200;300;400;500;600;700;800;900&display=swap"
          rel="stylesheet">
    <title>Kaicourses | Marketplace</title>
</head>
<body>
<div class="">
    <div>
        <nav class="bg-gray-800">
            <div class="px-8 mx-auto max-w-8xl">
                <div class="relative flex items-center justify-between h-16 px-10">
                    <div class="absolute inset-y-0 left-0 flex items-center sm:hidden">
                        <button type="button"
                                class="relative inline-flex items-center justify-between p-2 text-gray-400 rounded-md hover:bg-gray-700 hover:text-white focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white"
                                aria-controls="mobile-menu" aria-expanded="false">
                            <span class="absolute -inset-0.5"></span>
                            <span class="sr-only">Open main menu</span>
                            <svg class="block size-6" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                                 stroke="currentColor" aria-hidden="true" data-slot="icon">
                                <path stroke-linecap="round" stroke-linejoin="round"
                                      d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5"/>
                            </svg>
                            <svg class="hidden size-6" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                                 stroke="currentColor" aria-hidden="true" data-slot="icon">
                                <path stroke-linecap="round" stroke-linejoin="round" d="M6 18 18 6M6 6l12 12"/>
                            </svg>
                        </button>
                    </div>
                    <div class="flex items-center justify-center flex-1 sm:items-center sm:justify-start">
                        <a href="/home" class="cursor-pointer">
                            <div class="flex items-center shrink-0">
                                <img class="w-auto h-12" src="img/phonex_logo_prev_ui.png" alt="">
                            </div>
                        </a>
                        <div class="hidden sm:ml-6 sm:block">
                            <div class="flex space-x-4">
                                <a href="/productlist" class="px-3 py-2 text-sm font-medium text-white bg-gray-900 rounded-md"
                                   aria-current="page">Marketplace</a>
                                <a href="/trackingorder.jsp"
                                   class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white">Track the order</a>
                                <a href="#"
                                   class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white">Promotion</a>
                                <a href="/blog.jsp"
                                   class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white">Blogs</a>
                                <c:choose>
                                    <c:when test="${user.getRoleId() == 1}">
                                        <a href="/adminorderlist"
                                           class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white">Management</a>
                                    </c:when>
                                </c:choose>
                                <div class="flex items-center">
                                    <form action="searchproduct">
                                        <div class="bg-gray-800 flex px-2 py-2 border-b-2 border-[#333] focus-within:border-red-400 overflow-hidden max-w-md mx-auto font-[sans-serif]">
                                            <ion-icon class="mr-3 text-xl font-semibold text-gray-200 focus-within:text-red-400" name="search"></ion-icon>
                                            <input name="txtNameProductToSearch" type="text" class="w-full text-sm text-white bg-gray-800 outline-none" />
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class='flex items-center space-x-5 sm:space-x-3 '>
                        <div class="flex flex-col items-center justify-center gap-0.5 cursor-pointer px-2 py-1 rounded-md hover:bg-gray-700">
                            <div class="relative">
                                <a href="/forwardwishlist"><ion-icon class=" fill-[#333] text-gray-50 text-2xl" name="heart"></ion-icon></a>
                                <span class="absolute top-0 left-auto px-1 py-0 -ml-1 text-xs text-white bg-red-500 rounded-full">0</span>
                            </div>
                        </div>
                        <div class="flex flex-col items-center justify-center px-2 py-1 rounded-md hover:bg-gray-700">
                            <div class="relative">
                                <a href="/forwardcart"><ion-icon class=" fill-[#333] text-gray-50 text-2xl" name="cart"></ion-icon></a>
                                <span id="totalProductsOfCart" class="absolute top-0 left-auto px-1 py-0 -ml-1 text-xs text-white bg-red-500 rounded-full">${sessionScope.totalQuantity}</span>
                            </div>
                        </div>
                        <c:if test="${empty user}">
                            <a href="/login.jsp" class='px-4 py-2 text-sm text-white transition-all border-2 rounded-full max-lg:hidden hover:bg-indigo-600 hover:text-white hover:border-indigo-600 cursor-pointer'>Sign In</a>
                        </c:if>
                        <c:if test="${not empty user}">
                            <a href="/profiledefault.jsp" class="flex items-center font-light text-gray-100 text-md"><p>Welcome</p> <span class="text-red-400 font-bold">,   ${user.getUsername()}</span><img class="w-auto h-10 ml-2 rounded-full" src="img/${user.getImageUrl()}"></a>
                        </c:if>
                        <button id="toggleOpen" class='lg:hidden'>
                            <svg class="w-7 h-7" fill="#333" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd"
                                      d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
                                      clip-rule="evenodd"></path>
                            </svg>
                        </button>
                    </div>
                </div>
            </div>
        </nav>
        <div class="max-h-full">
            <div class="flex bg-gradient-to-r">

                <div class="flex flex-col h-full mt-8 ml-6 text-white bg-gray-900 w-72 rounded-2xl">
                    <!-- Logo & Toggle Button -->
                    <div class="flex items-center justify-between px-4 py-4 border-b border-gray-700">
                        <div class="text-3xl font-bold text-white">
                            <ion-icon name="notifications"></ion-icon>
                        </div>
                        <h2>Dashboard</h2>
                    </div>
                    <!-- Video Section -->
                    <div class="px-4 py-6 border-b border-gray-700">
                        <div class="overflow-hidden bg-gray-800 rounded-lg shadow-md">
                            <video
                                    class="w-full transition-opacity duration-300 rounded-lg h-50 hover:opacity-90"
                                    controls>
                                <source src="img/3196344-uhd_3840_2160_25fps.mp4" type="video/mp4">
                            </video>
                        </div>
                    </div>
                    <!-- Menu Items -->
                    <nav class="flex-1 px-2 py-6 space-y-2">
                        <!-- Suppliers Section -->
                        <div class="group">
                            <div class="flex items-center justify-between max-w-full rounded-md group-hover:bg-gray-700" onclick="toggleSection('suppliersSection', 'dropdown_supplierId')">
                                <a class="flex items-center p-2 space-x-3 rounded-md">
                                    <ion-icon name="cube"></ion-icon>
                                    <span>Suppliers</span>
                                </a>
                                <ion-icon id="dropdown_supplierId" name="chevron-back"></ion-icon>
                            </div>
                            <!-- Mục danh sách Suppliers -->
                            <div id="suppliersSection" class="hidden space-y-2 bg-gray-900 rounded-md shadow-lg group-hover:block">
                                <c:forEach var="supplier" items="${suppliersList}">
                                    <a href="/ofsuppliers?supplierId=${supplier.getId()}" class="block px-4 py-1 ml-3 text-white rounded-md hover:bg-gray-700">${supplier.getCompanyName()}</a>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="group">
                            <div class="flex items-center justify-between rounded-md group-hover:bg-gray-700" onclick="toggleSection('categoriesSection', 'dropdown_categoriesId')">
                                <a class="flex items-center p-2 space-x-3 rounded-md">
                                    <ion-icon name="keypad"></ion-icon>
                                    <span>Categories</span>
                                </a>
                                <ion-icon id="dropdown_categoriesId" name="chevron-back"></ion-icon>
                            </div>
                            <div id="categoriesSection" class="hidden space-y-2 bg-gray-900 rounded-md shadow-lg group-hover:block">
                                <c:forEach var="category" items="${categoriesList}">
                                    <a href="/ofcategories?categoryId=${category.getId()}" class="block px-4 py-1 ml-3 text-white rounded-md hover:bg-gray-700">${category.getName()}</a>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="group">
                            <div class="flex items-center justify-between rounded-md group-hover:bg-gray-700" onclick="toggleSection('rangeSection', 'dropdown_rangeId')">
                                <a href="#" class="flex items-center p-2 space-x-3 rounded-md">
                                    <ion-icon name="pizza"></ion-icon>
                                    <span>Range($)</span>
                                </a>
                                <ion-icon id="dropdown_rangeId" name="chevron-back"></ion-icon>
                            </div>
                            <div id="rangeSection" class="hidden space-y-2 bg-gray-900 rounded-md shadow-lg group-hover:block">
                                <form action="/range" class="flex justify-center">
                                    <div>
                                        <div>
                                            <label for="price" class="block text-sm text-gray-50">From</label>
                                            <div class="mt-1">
                                                <div class="flex items-center w-40 px-2 py-1 bg-white rounded outline outline-1 outline-gray-300 focus-within:outline-2 focus-within:outline-indigo-600">
                                                    <div class="text-sm text-gray-500 select-none">$</div>
                                                    <input type="number" name="txtPriceFrom" id="price45"
                                                           class="block w-full pl-2 text-sm text-gray-900 placeholder-gray-400 focus:outline-none"
                                                           placeholder="0.00">
                                                    <select id="currency45" name="currency"
                                                            class="ml-2 text-sm text-gray-500 bg-transparent focus:outline-none">
                                                        <option>USD</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="mt-4">
                                            <label for="price" class="block text-sm text-gray-50">To</label>
                                            <div class="mt-1">
                                                <div class="flex items-center w-40 px-2 py-1 bg-white rounded outline outline-1 outline-gray-300 focus-within:outline-2 focus-within:outline-indigo-600">
                                                    <div class="text-sm text-gray-500 select-none">$</div>
                                                    <input type="number" name="txtPriceTo" id="price"
                                                           class="block w-full pl-2 text-sm text-gray-900 placeholder-gray-400 focus:outline-none"
                                                           placeholder="0.00">
                                                    <select id="currency" name="currency"
                                                            class="ml-2 text-sm text-gray-500 bg-transparent focus:outline-none">
                                                        <option>USD</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <button type="submit"
                                                class="mt-4 w-40 px-3 py-1.5 text-sm text-white bg-indigo-600 rounded shadow hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-600 transition">
                                            Search
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>

                        <a href="#" class="flex items-center px-2 py-2 pt-2 space-x-3 rounded-md hover:bg-gray-700">
                            <ion-icon name="pricetags"></ion-icon>
                            <span>HotSales</span>
                        </a>
                        <a href="#" class="flex items-center px-2 py-2 space-x-3 rounded-md hover:bg-gray-700 ">
                            <ion-icon name="pizza"></ion-icon>
                            <span>NewPizza</span>
                        </a>
                        <a href="#" class="flex items-center px-2 py-2 space-x-3 rounded-md hover:bg-gray-700 ">
                            <ion-icon name="chatbubble"></ion-icon>
                            <span>Supports</span>
                        </a>
                        <a href="#" class="flex items-center px-2 py-2 space-x-3 rounded-md hover:bg-gray-700 ">
                            <ion-icon name="call"></ion-icon>
                            <span>Contact</span>
                        </a>
                    </nav>
                    <!-- Profile & Logout -->
                    <div class="px-2 py-6 border-t border-gray-700">
                        <a href="/profiledefault.jsp" class="flex items-center p-2 space-x-3 rounded-md hover:bg-gray-700">
                            <ion-icon name="person"></ion-icon>
                            <span>Profile</span>
                        </a>
                        <a href="/logout" class="flex items-center p-2 space-x-3 rounded-md hover:bg-gray-700">
                            <ion-icon name="log-out"></ion-icon>
                            <span>Logout</span>
                        </a>
                    </div>
                </div>
                <!-- Main Content -->
                <div class="flex-1 p-2">
                    <div class="">
                        <div class="flex items-center justify-center px-8 pt-5">
                            <div class="relative w-full max-w-5xl overflow-hidden rounded-lg">
                                <!-- Khung chứa hình ảnh -->
                                <div class="flex transition-transform duration-500 ease-in-out" id="carousel-images"
                                     style="transform: translateX(0%);">
                                    <img class="flex-shrink-0 object-contain w-full h-96" src="/img/banner01.png"
                                         alt="Banner 1">
                                    <img class="flex-shrink-0 object-contain w-full h-96" src="/img/banner02.png"
                                         alt="Banner 2">
                                    <img class="flex-shrink-0 object-contain w-full h-96" src="/img/banner03.png"
                                         alt="Banner 3">
                                </div>

                                <!-- Nút mũi tên -->
                                <button class="absolute text-5xl text-gray-500 transform -translate-y-1/2 rounded-full left-4 top-1/2"
                                        onclick="prevSlide()">
                                    <ion-icon name="chevron-back-outline"></ion-icon>
                                </button>
                                <button class="absolute text-5xl text-gray-500 transform -translate-y-1/2 rounded-full right-4 top-1/2"
                                        onclick="nextSlide()">
                                    <ion-icon name="chevron-forward-outline"></ion-icon>
                                </button>
                            </div>
                        </div>
                        <div class="flex justify-center mt-3">
                            <div class="flex justify-center py-1 items-center relative bg-gradient-to-r from-indigo-500 via-purple-500 to-pink-500 rounded-lg shadow-lg text-white w-1/2">
                                <ion-icon name="ribbon" class="text-yellow-400 text-2xl pr-1"></ion-icon>
                                <a href="/register.jsp" class="text-md font-bold italic pr-2 hover:underline">Sign up now!</a>
                                <p class="text-base pr-3">Earn points now, thousands of gifts are waiting for you!</p>
                            </div>
                        </div>
                        <div class="bg-white">
                            <div class="max-w-2xl px-4 py-8 mx-auto sm:px-6 sm:py-8 lg:max-w-7xl lg:px-8">
                                <h2 class="italic front-light text-red-500 text-xl mb-4">Products here!</h2>
                                <c:if test="${not empty keysearch}">
                                    <strong class="italic front-light text-gray-600 text-xl mb-4">The result
                                        of </strong><strong class="text-red-500">'${keysearch}'</strong>
                                </c:if>
                                <c:if test="${empty productEmptyMsg}">
                                    <h2 class="text-red-400 ml-16">${productEmptyMsg}</h2>
                                </c:if>
                                <div class="grid grid-cols-1 gap-x-6 gap-y-10 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 xl:gap-x-8 mt-4">
                                    <c:forEach var="product" items="${productsListPages}">
                                        <a class="group cursor-pointer">
                                            <img onclick="window.location.href='/productoverview?id=${product.getId()}'" src="img/product/${product.getProductImgUrl()}"
                                                 alt="Tall slender porcelain bottle with natural clay textured body and cork stopper."
                                                 class="aspect-square w-full rounded-lg bg-gray-200 object-cover group-hover:opacity-75 xl:aspect-[7/8]">
                                            <h3 onclick="window.location.href='/productoverview?id=${product.getId()}'" class="mt-4 text-lg text-gray-700">${product.getName()}</h3>
                                            <p onclick="window.location.href='/productoverview?id=${product.getId()}'" class="mt-1 text-lg font-medium text-gray-900">$${product.getPrice()}</p>

                                            <!-- Thêm phần nút dưới đây -->
                                            <div class="flex mt-4 space-x-4">
                                                <button onclick="addToCart(${product.getId()}, '1')" class="px-2 py-2 text-sm font-semibold text-white transition duration-200 ease-in-out bg-blue-600 rounded-md shadow-md hover:bg-blue-700 flex items-center">
                                                    <ion-icon class="text-xl font-bold  " name="cart-outline"></ion-icon> Add to Cart
                                                </button>
                                                <button onclick="window.location.href='/productoverview?id=${product.getId()}'" class="px-5 py-2 text-sm font-semibold text-white transition duration-200 ease-in-out bg-green-600 rounded-md shadow-md hover:bg-green-700">
                                                    View Details
                                                </button>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                                <div class="flex items-center justify-between px-4 py-3 bg-white border-t border-gray-200 sm:px-6 mt-4">
                                    <div class="flex justify-between flex-1 sm:hidden">
                                        <a href="#"
                                           class="relative inline-flex items-center px-4 py-2 text-sm font-medium text-gray-700 bg-white border border-gray-300 rounded-md hover:bg-gray-50">Previous</a>
                                        <a href="#"
                                           class="relative inline-flex items-center px-4 py-2 ml-3 text-sm font-medium text-gray-700 bg-white border border-gray-300 rounded-md hover:bg-gray-50">Next</a>
                                    </div>
                                    <div class="hidden sm:flex sm:flex-1 sm:items-center sm:justify-between">
                                        <div>
                                            <p class="text-sm text-gray-700">
                                                Showing
                                                <span class="font-medium">${currentpages}</span>
                                                to
                                                <span class="font-medium">${totalPages}</span>
                                                of
                                                <span class="font-medium">${totalProducts}</span>
                                                results
                                            </p>
                                        </div>
                                        <div>
                                            <nav class="inline-flex -space-x-px rounded-md shadow-sm isolate"
                                                 aria-label="Pagination">
                                                <c:if test="${not empty isProductList}">
                                                    <a href="/productlist?page=${(currentpages - 1) > 0 ? currentpages - 1: 1}&size=8"
                                                       class="relative inline-flex items-center px-2 py-2 text-gray-400 rounded-l-md ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                                                        <span class="sr-only">Previous</span>
                                                        <ion-icon name="chevron-back-outline"></ion-icon>
                                                    </a>
                                                    <c:forEach var="page" begin="1" end="${totalPages}">
                                                        <a href="/productlist?page=${page}&size=8"
                                                           class="relative inline-flex items-center px-4 py-2 text-sm font-semibold
                                                            ${page == currentPage ? 'text-white bg-indigo-600 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600' : 'text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:outline-offset-0'}">
                                                                ${page}
                                                        </a>
                                                    </c:forEach>
                                                    <a href="/productlist?page=${(currentpages + 1) >= totalPages ? totalPages : currentPage + 1}&size=8"
                                                       class="relative inline-flex items-center px-2 py-2 text-gray-400 rounded-r-md ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                                                        <span class="sr-only">Next</span>
                                                        <ion-icon name="chevron-forward-outline"></ion-icon>
                                                    </a>
                                                </c:if>
                                                <c:if test="${not empty isProductSearch}">
                                                    <a href="/searchproduct?txtNameProductToSearch=${keysearch}&page=${(currentpages - 1) > 0 ? currentpages - 1: 1}&size=8"
                                                       class="relative inline-flex items-center px-2 py-2 text-gray-400 rounded-l-md ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                                                        <span class="sr-only">Previous</span>
                                                        <ion-icon name="chevron-back-outline"></ion-icon>
                                                    </a>
                                                    <!-- Current: "z-10 bg-indigo-600 text-white focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600", Default: "text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:outline-offset-0" -->
                                                    <c:forEach var="page" begin="1" end="${totalPages}">
                                                        <a href="/searchproduct?txtNameProductToSearch=${keysearch}&page=${page}&size=8"
                                                           class="relative inline-flex items-center px-4 py-2 text-sm font-semibold
                                                            ${page == currentPage ? 'text-white bg-indigo-600 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600' : 'text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:outline-offset-0'}">
                                                                ${page}
                                                        </a>
                                                    </c:forEach>
                                                    <a href="/searchproduct?txtNameProductToSearch=${keysearch}&page=${(currentpages + 1) >= totalPages ? totalPages : currentPage + 1}&size=8"
                                                       class="relative inline-flex items-center px-2 py-2 text-gray-400 rounded-r-md ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                                                        <span class="sr-only">Next</span>
                                                        <ion-icon name="chevron-forward-outline"></ion-icon>
                                                    </a>
                                                </c:if>
                                                <c:if test="${not empty isRange}">
                                                    <a href="/range?txtPriceFrom=${txtPriceFrom}&txtPriceTo=${txtPriceTo}&page=${(currentpages - 1) > 0 ? currentpages - 1: 1}&size=8"
                                                       class="relative inline-flex items-center px-2 py-2 text-gray-400 rounded-l-md ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                                                        <span class="sr-only">Previous</span>
                                                        <ion-icon name="chevron-back-outline"></ion-icon>
                                                    </a>
                                                    <!-- Current: "z-10 bg-indigo-600 text-white focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600", Default: "text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:outline-offset-0" -->
                                                    <c:forEach var="page" begin="1" end="${totalPages}">
                                                        <a href="/range?txtPriceFrom=${txtPriceFrom}&txtPriceTo=${txtPriceTo}&page=${page}&size=8"
                                                           class="relative inline-flex items-center px-4 py-2 text-sm font-semibold
                                                            ${page == currentPage ? 'text-white bg-indigo-600 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600' : 'text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:outline-offset-0'}">
                                                                ${page}
                                                        </a>
                                                    </c:forEach>
                                                    <a href="/range?txtPriceFrom=${txtPriceFrom}&txtPriceTo=${txtPriceTo}&page=${(currentpages + 1) >= totalPages ? totalPages : currentPage + 1}&size=8"
                                                       class="relative inline-flex items-center px-2 py-2 text-gray-400 rounded-r-md ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                                                        <span class="sr-only">Next</span>
                                                        <ion-icon name="chevron-forward-outline"></ion-icon>
                                                    </a>
                                                </c:if>
                                                <c:if test="${not empty isSupplier}">
                                                    <a href="/ofsuppliers?supplierId=${supplierId}&page=${(currentpages - 1) > 0 ? currentpages - 1: 1}&size=8"
                                                       class="relative inline-flex items-center px-2 py-2 text-gray-400 rounded-l-md ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                                                        <span class="sr-only">Previous</span>
                                                        <ion-icon name="chevron-back-outline"></ion-icon>
                                                    </a>
                                                    <!-- Current: "z-10 bg-indigo-600 text-white focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600", Default: "text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:outline-offset-0" -->
                                                    <c:forEach var="page" begin="1" end="${totalPages}">
                                                        <a href="/ofsuppliers?supplierId=${supplierId}&page=${page}&size=8"
                                                           class="relative inline-flex items-center px-4 py-2 text-sm font-semibold
                                                            ${page == currentPage ? 'text-white bg-indigo-600 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600' : 'text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:outline-offset-0'}">
                                                                ${page}
                                                        </a>
                                                    </c:forEach>
                                                    <a href="/ofsuppliers?supplierId=${supplierId}&page=${(currentpages + 1) >= totalPages ? totalPages : currentPage + 1}&size=8"
                                                       class="relative inline-flex items-center px-2 py-2 text-gray-400 rounded-r-md ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                                                        <span class="sr-only">Next</span>
                                                        <ion-icon name="chevron-forward-outline"></ion-icon>
                                                    </a>
                                                </c:if>
                                                <c:if test="${not empty isCategories}">
                                                    <a href="/ofcategories?categoryId=${categoryId}&page=${(currentpages - 1) > 0 ? currentpages - 1: 1}&size=8"
                                                       class="relative inline-flex items-center px-2 py-2 text-gray-400 rounded-l-md ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                                                        <span class="sr-only">Previous</span>
                                                        <ion-icon name="chevron-back-outline"></ion-icon>
                                                    </a>
                                                    <!-- Current: "z-10 bg-indigo-600 text-white focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600", Default: "text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:outline-offset-0" -->
                                                    <c:forEach var="page" begin="1" end="${totalPages}">
                                                        <a href="/ofcategories?categoryId=${categoryId}&page=${page}&size=8"
                                                           class="relative inline-flex items-center px-4 py-2 text-sm font-semibold
                                                            ${page == currentPage ? 'text-white bg-indigo-600 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600' : 'text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:outline-offset-0'}">
                                                                ${page}
                                                        </a>
                                                    </c:forEach>
                                                    <a href="/ofcategories?categoryId=${categoryId}&page=${(currentpages + 1) >= totalPages ? totalPages : currentPage + 1}&size=8"
                                                       class="relative inline-flex items-center px-2 py-2 text-gray-400 rounded-r-md ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                                                        <span class="sr-only">Next</span>
                                                        <ion-icon name="chevron-forward-outline"></ion-icon>
                                                    </a>
                                                </c:if>
                                            </nav>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="bg-gray-900 py-6 sm:px-16 max-sm:px-8 font-sans tracking-wide">
                <div class="max-w-xl mx-auto text-center">
                    <h4 class="mb-6 text-lg text-white">Join our newsletter to keep up to date with us!</h4>
                    <div class="bg-white flex p-1 rounded-full text-left">
                        <input type='email' placeholder='Enter your email' class= "rounded-full w-full outline-none text-[15px] pl-4" />
                        <button type='button'
                                class="bg-indigo-500 text-white text-[15px] rounded-full px-4 py-2 tracking-wide hover:bg-indigo-600 transition-all">Subscribe</button>
                    </div>
                </div>

                <hr class="my-10 border-gray-400" />

                <div class="grid grid-cols-1 gap-8 sm:grid-cols-2 lg:grid-cols-5">
                    <div class="max-w-md lg:col-span-2">
                        <h4 class="mb-4 text-lg font-bold text-gray-200">Follow us</h4>
                        <ion-icon class="text-3xl text-gray-200 cursor-pointer hover:text-blue-500" name="logo-facebook"></ion-icon>
                        <ion-icon class="text-3xl text-gray-200 cursor-pointer hover:text-yellow-500" name="logo-github"></ion-icon>
                        <ion-icon class="text-3xl text-gray-200 cursor-pointer hover:text-blue-500" name="logo-twitter"></ion-icon>
                        <ion-icon class="text-3xl text-gray-200 cursor-pointer hover:text-green-500" name="logo-edge"></ion-icon>
                        <ion-icon class="text-3xl text-gray-200 cursor-pointer hover:text-red-500" name="logo-youtube"></ion-icon>
                    </div>

                    <div>
                        <h4 class="mb-6 text-lg text-white">Services</h4>
                        <ul class="space-y-4">
                            <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Web
                                Development</a></li>
                            <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Mobile App
                                Development</a></li>
                            <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">UI/UX
                                Design</a></li>
                            <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Digital Marketing</a></li>
                        </ul>
                    </div>

                    <div>
                        <h4 class="mb-6 text-lg text-white">Resources</h4>
                        <ul class="space-y-4">
                            <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Webinars</a>
                            </li>
                            <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Ebooks</a>
                            </li>
                            <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Templates</a>
                            </li>
                            <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Tutorials</a></li>
                        </ul>
                    </div>

                    <div>
                        <h4 class="mb-6 text-lg text-white">About Us</h4>
                        <ul class="space-y-4">
                            <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Our Story</a>
                            </li>
                            <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Mission and
                                Values</a></li>
                            <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Team</a></li>
                            <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Testimonials</a></li>
                        </ul>
                    </div>
                </div>

                <p class='text-gray-300 text-[15px] mt-10'>© Kaicourses. Created by devcldkai229.</p>
            </footer>
        </div>
    </div>
</div>
<script src="js/marketplace.js">
</script>
<script src="js/marketplace2.js">
</script>
<script src="js/addtocart.js">
</script>
</body>
</html>
