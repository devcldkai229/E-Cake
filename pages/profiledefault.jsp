<%@ page import="devcldkai.kaipizzas.domain.entities.Accounts" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kaicourses | Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</head>
<script src="js/profiledefault.js">
</script>
<body>
<div class="bg-gray-50">

    <div>
        <div class="relative pb-32 overflow-hidden bg-gradient-to-r from-pink-400 to-blue-400">
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
                                    <a href="/productlist" class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white"
                                       aria-current="page">Marketplace</a>
                                    <a href="/trackingorder.jsp"
                                       class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white">Track the order</a>
                                    <a href="#"
                                       class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white">Promotion</a>
                                    <a href="/blog.jsp"
                                       class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white">Blogs</a>
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
                                    <a href="/forwardwishlist"><ion-icon class="  text-gray-50 text-2xl" name="heart"></ion-icon></a>
                                    <span class="absolute top-0 left-auto px-1 py-0 -ml-1 text-xs text-white bg-red-500 rounded-full">0</span>
                                </div>
                            </div>
                            <div class="flex flex-col items-center justify-center px-2 py-1 rounded-md hover:bg-gray-700">
                                <div class="relative">
                                    <a href="/forwardcart"><ion-icon class="  text-gray-50 text-2xl" name="cart"></ion-icon></a>
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
            <header class="relative py-10">
                <div class="px-4 mx-auto max-w-7xl sm:px-6 lg:px-8">
                    <h1 class="text-3xl font-bold tracking-tight text-white">Settings</h1>
                </div>
            </header>
        </div>

        <main class="relative -mt-32">
            <div class="max-w-screen-xl px-4 pb-6 mx-auto sm:px-6 lg:px-8 lg:pb-16">
                <div class="overflow-hidden bg-white rounded-lg shadow">
                    <div class="divide-y divide-gray-200 lg:grid lg:grid-cols-12 lg:divide-y-0 lg:divide-x">
                        <aside class="py-6 lg:col-span-3">
                            <nav class="space-y-1">

                                <a href="/profiledefault.jsp"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-teal-700 border-l-4 border-teal-500 bg-teal-50 hover:bg-teal-50 hover:text-teal-700 group"
                                   x-state:on="Current" x-state:off="Default" aria-current="page"
                                   x-state-description="Current: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, Default: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl" name="person-circle-outline"></ion-icon>
                                    <span class="truncate">Profile</span>
                                </a>

                                <a href="/profileaccount.jsp"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="cog-outline"></ion-icon>
                                    <span class="truncate">Account</span>
                                </a>

                                <a href="/profilepassword.jsp"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="key-outline"></ion-icon>
                                    <span class="truncate">Password</span>
                                </a>

                                <a href="/rewards"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="gift-outline"></ion-icon>
                                    <span class="truncate">Rewards</span>
                                </a>

                                <a href="/historyOrdered"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="bag-check-outline"></ion-icon>
                                    <span class="truncate">History</span>
                                </a>

                                <a href="#"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="notifications-outline"></ion-icon>
                                    <span class="truncate">Notifications</span>
                                </a>

                                <a href="#"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="wallet-outline"></ion-icon>
                                    <span class="truncate">Payment</span>
                                </a>

                                <a href="#"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="logo-electron"></ion-icon>
                                    <span class="truncate">Integrations</span>
                                </a>

                                <a href="/logout"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="log-out-outline"></ion-icon>
                                    <span class="truncate">Log out</span>
                                </a>
                            </nav>
                        </aside>

                        <form id="profileDefaultForm" class="divide-y divide-gray-200 lg:col-span-9" onsubmit="updateProfileDefault(event)" method="POST" enctype="multipart/form-data">
                            <!-- Profile section -->
                            <div class="px-4 py-6 sm:p-6 lg:pb-8">
                                <div>
                                    <h2 class="text-2xl font-medium leading-6 text-gray-900">Profile</h2>
                                    <p class="mt-1 text-sm text-gray-600">This information will be displayed publicly so be careful what
                                        you share.</p>
                                </div>

                                <div class="flex flex-col mt-6 lg:flex-row">
                                    <div class="flex-grow space-y-6">
                                        <div>
                                            <label for="username" class="block text-sm font-medium text-gray-700">Username</label>
                                            <div class="flex mt-1 rounded-md shadow-sm">
                                                <span class="inline-flex items-center px-3 text-gray-500 border border-r-0 border-gray-300 rounded-l-md bg-gray-50 sm:text-sm">kaicourses.com/</span>
                                                <input name="username" id="username" autocomplete="username" class="flex-grow block w-full min-w-0 px-1 border-gray-300 rounded-none rounded-r-md focus:border-sky-500 focus:ring-sky-500 sm:text-sm" value="${sessionScope.user.getUsername()}" disabled>
                                            </div>
                                        </div>
                                        <div>
                                            <label for="about" class="block text-sm font-medium text-gray-700">About</label>
                                            <div class="mt-1">
                                                <input value="${sessionScope.user.getAbout()}" id="about" name="about" class="block w-full mt-1 px-3 py-2 border-gray-300 rounded-md shadow-sm focus:border-sky-500 focus:ring-sky-500 sm:text-sm"></input>
                                            </div>
                                            <p class="mt-2 text-sm text-gray-500">Brief description for your profile. URLs are hyperlinked.
                                            </p>
                                        </div>
                                    </div>

                                    <div class="flex-grow mt-6 lg:mt-0 lg:ml-6 lg:flex-shrink-0 lg:flex-grow-0">
                                        <p class="text-sm font-medium text-gray-700" aria-hidden="true">Avatar</p>
                                        <div class="relative hidden overflow-hidden rounded-full lg:block">
                                            <img id="imageStatic" class="relative w-40 h-40 rounded-full" src="img/${sessionScope.user.getImageUrl()}" alt="">
                                            <label class="absolute inset-0 flex items-center justify-center w-full h-full text-sm font-medium text-white bg-black bg-opacity-75 opacity-0 focus-within:opacity-100 hover:opacity-100">
                                                <span>Upload</span>
                                                <span class="sr-only"> user photo</span>
                                                <input onchange="onChangeImageInProfileUser(event)" type="file" id="fileUpload" name="user-photo" class="absolute inset-0 w-full h-full border-gray-300 rounded-md opacity-0 cursor-pointer">
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <div class="grid grid-cols-12 gap-6 mt-6">
                                    <div class="col-span-12 sm:col-span-6">
                                        <label for="first-name" class="block text-sm font-medium text-gray-700">First name</label>
                                        <input value="${sessionScope.user.getFirstName()}" type="text" name="firstName" id="first-name" class="block w-full px-3 py-2 mt-1 border border-gray-300 rounded-md shadow-sm focus:border-sky-500 focus:outline-none focus:ring-sky-500 sm:text-sm">
                                    </div>

                                    <div class="col-span-12 sm:col-span-6">
                                        <label for="last-name" class="block text-sm font-medium text-gray-700">Last name</label>
                                        <input value="${sessionScope.user.getLastName()}" type="text" name="lastName" id="last-name" class="block w-full px-3 py-2 mt-1 border border-gray-300 rounded-md shadow-sm focus:border-sky-500 focus:outline-none focus:ring-sky-500 sm:text-sm">
                                    </div>
                                    <%
                                        Accounts user = (Accounts) request.getSession().getAttribute("user");
                                        String dateOfBirth = (user.getDateOfBirth() == null) ? "" : user.getDateOfBirth().toString();
                                    %>

                                    <div class="col-span-12 sm:col-span-6">
                                        <label for="date-of-birth" class="block text-sm font-medium text-gray-700">Date of birth</label>
                                        <input value="<%= dateOfBirth %>" type="date" name="dateOfBirth" id="date-of-birth"
                                               class="block w-full px-3 py-2 mt-1 border border-gray-300 rounded-md shadow-sm focus:border-sky-500 focus:outline-none focus:ring-sky-500 sm:text-sm">
                                    </div>

                                    <div class="col-span-12 sm:col-span-6">
                                        <label for="phone-number" class="block text-sm font-medium text-gray-700">Phone</label>
                                        <input value="${sessionScope.user.getPhone()}" type="text" name="phoneNumber" id="phone-number" class="block w-full px-3 py-2 mt-1 border border-gray-300 rounded-md shadow-sm focus:border-sky-500 focus:outline-none focus:ring-sky-500 sm:text-sm">
                                    </div>
                                </div>
                            </div>

                            <div class="pt-6 divide-y divide-gray-200">
                                <div class="px-4 sm:px-6">
                                    <div>
                                        <h2 class="text-lg font-medium leading-6 text-gray-900">Privacy</h2>
                                        <p class="mt-1 text-sm text-gray-500">Ornare eu a volutpat eget vulputate. Fringilla commodo amet.
                                        </p>
                                    </div>
                                    <ul role="list" class="mt-2 divide-y divide-gray-200">
                                        <li class="flex items-center justify-between py-4">
                                            <div class="flex flex-col">
                                                <p class="text-sm font-medium text-gray-900" id="privacy-option-1-label">Available to hire</p>
                                                <p class="text-sm text-gray-500" id="privacy-option-1-description">Nulla amet tempus sit
                                                    accumsan. Aliquet turpis sed sit lacinia.</p>
                                            </div>
                                            <button type="button" class="relative inline-flex flex-shrink-0 h-6 ml-4 transition-colors duration-200 ease-in-out bg-gray-200 border-2 border-transparent rounded-full cursor-pointer w-11 focus:outline-none focus:ring-2 focus:ring-sky-500 focus:ring-offset-2" role="switch" aria-checked="true" x-ref="switch" x-state:on="Enabled" x-state:off="Not Enabled" :class="{ 'bg-teal-500': on, 'bg-gray-200': !(on) }" aria-labelledby="privacy-option-1-label" aria-describedby="privacy-option-1-description" :aria-checked="on.toString()" @click="on = !on">
                                                <span aria-hidden="true" class="inline-block w-5 h-5 transition duration-200 ease-in-out transform translate-x-0 bg-white rounded-full shadow ring-0" x-state:on="Enabled" x-state:off="Not Enabled" :class="{ 'translate-x-5': on, 'translate-x-0': !(on) }"></span>
                                            </button>
                                        </li>
                                        <li class="flex items-center justify-between py-4">
                                            <div class="flex flex-col">
                                                <p class="text-sm font-medium text-gray-900" id="privacy-option-2-label">Make account private
                                                </p>
                                                <p class="text-sm text-gray-500" id="privacy-option-2-description">Pharetra morbi dui mi mattis
                                                    tellus sollicitudin cursus pharetra.</p>
                                            </div>
                                            <button type="button" class="relative inline-flex flex-shrink-0 h-6 ml-4 transition-colors duration-200 ease-in-out bg-gray-200 border-2 border-transparent rounded-full cursor-pointer w-11 focus:outline-none focus:ring-2 focus:ring-sky-500 focus:ring-offset-2" role="switch" aria-checked="false" x-ref="switch" x-state:on="Enabled" x-state:off="Not Enabled" :class="{ 'bg-teal-500': on, 'bg-gray-200': !(on) }" aria-labelledby="privacy-option-2-label" aria-describedby="privacy-option-2-description" :aria-checked="on.toString()" @click="on = !on">
                                                <span aria-hidden="true" class="inline-block w-5 h-5 transition duration-200 ease-in-out transform translate-x-0 bg-white rounded-full shadow ring-0" x-state:on="Enabled" x-state:off="Not Enabled" :class="{ 'translate-x-5': on, 'translate-x-0': !(on) }"></span>
                                            </button>
                                        </li>
                                        <li class="flex items-center justify-between py-4">
                                            <div class="flex flex-col">
                                                <p class="text-sm font-medium text-gray-900" id="privacy-option-3-label">Allow commenting</p>
                                                <p class="text-sm text-gray-500" id="privacy-option-3-description">Integer amet, nunc hendrerit
                                                    adipiscing nam. Elementum ame</p>
                                            </div>
                                            <button type="button" class="relative inline-flex flex-shrink-0 h-6 ml-4 transition-colors duration-200 ease-in-out bg-gray-200 border-2 border-transparent rounded-full cursor-pointer w-11 focus:outline-none focus:ring-2 focus:ring-sky-500 focus:ring-offset-2" role="switch" aria-checked="true" x-ref="switch" x-state:on="Enabled" x-state:off="Not Enabled" :class="{ 'bg-teal-500': on, 'bg-gray-200': !(on) }" aria-labelledby="privacy-option-3-label" aria-describedby="privacy-option-3-description" :aria-checked="on.toString()" @click="on = !on">
                                                <span aria-hidden="true" class="inline-block w-5 h-5 transition duration-200 ease-in-out transform translate-x-0 bg-white rounded-full shadow ring-0" x-state:on="Enabled" x-state:off="Not Enabled" :class="{ 'translate-x-5': on, 'translate-x-0': !(on) }"></span>
                                            </button>
                                        </li>
                                        <li class="flex items-center justify-between py-4">
                                            <div class="flex flex-col">
                                                <p class="text-sm font-medium text-gray-900" id="privacy-option-4-label">Allow mentions</p>
                                                <p class="text-sm text-gray-500" id="privacy-option-4-description">Adipiscing est venenatis enim
                                                    molestie commodo eu gravid</p>
                                            </div>
                                            <button type="button" class="relative inline-flex flex-shrink-0 h-6 ml-4 transition-colors duration-200 ease-in-out bg-gray-200 border-2 border-transparent rounded-full cursor-pointer w-11 focus:outline-none focus:ring-2 focus:ring-sky-500 focus:ring-offset-2" role="switch" aria-checked="true" x-ref="switch" x-state:on="Enabled" x-state:off="Not Enabled" :class="{ 'bg-teal-500': on, 'bg-gray-200': !(on) }" aria-labelledby="privacy-option-4-label" aria-describedby="privacy-option-4-description" :aria-checked="on.toString()" @click="on = !on">
                                                <span aria-hidden="true" class="inline-block w-5 h-5 transition duration-200 ease-in-out transform translate-x-0 bg-white rounded-full shadow ring-0" x-state:on="Enabled" x-state:off="Not Enabled" :class="{ 'translate-x-5': on, 'translate-x-0': !(on) }"></span>
                                            </button>
                                        </li>
                                    </ul>
                                </div>
                                <div class="flex justify-end px-4 py-4 mt-4 sm:px-6">
                                    <button type="button" class="inline-flex justify-center px-4 py-2 text-sm font-medium text-gray-700 bg-white border border-gray-300 rounded-md shadow-sm hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-sky-500 focus:ring-offset-2">Cancel</button>
                                    <button type="submit" class="inline-flex justify-center px-4 py-2 ml-5 text-sm font-medium text-white border border-transparent rounded-md shadow-sm bg-sky-700 hover:bg-sky-800 focus:outline-none focus:ring-2 focus:ring-sky-500 focus:ring-offset-2">Save</button>
                                </div>
                            </div>
                        </form>
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
        </main>
    </div>
</div>
</body>
</html>

