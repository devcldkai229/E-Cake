<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <link href="css/homepage.css" rel="stylesheet">
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Inconsolata:wght@200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <title>Kaicourses | Home</title>
    <style>
        body {
            position: relative;
            background-image: url("/img/ai-generated-8699605_1920.jpg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }

        body::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.4);
            z-index: -1;
        }
    </style>
</head>
<div class="">
    <header class="absolute inset-x-0 top-0 z-50 border-b-indigo-500">
        <nav class="flex items-center justify-between p-6 lg:px-8" aria-label="Global">
            <div class="flex lg:flex-1">
                <a href="/home" class="-m-1.5 p-1.5">
                    <span class="sr-only">Your Company</span>
                    <img class="w-24 h-14" src="img/phonex_logo_prev_ui.png" alt="">
                </a>
            </div>
            <div class="flex lg:hidden">
                <button type="button" class="-m-2.5 inline-flex items-center justify-center rounded-md p-2.5 text-gray-700">
                    <span class="sr-only">Open main menu</span>
                    <svg class="size-6" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" aria-hidden="true" data-slot="icon">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5" />
                    </svg>
                </button>
            </div>
            <div class="hidden lg:flex lg:gap-x-12">
                <a href="/productlist" class="font-semibold text-gray-100 text-sm/6 hover:text-red-500">Marketplace</a>
                <div class="dropdown">
                    <a href="/home" class="font-semibold text-gray-100 text-sm/6 hover:text-red-500">Categories</a>
                    <ul class="dropdown-menu">
                        <c:forEach var="item" items="${categoriesList}">
                            <li><a href="/ofcategories?categoryId=${item.getId()}" class="dropdown-item hover:text-red-500">${item.getName()}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <a href="#" class="font-semibold text-gray-100  text-sm/6 hover:text-red-500">Reviews</a>
                <a href="/contact.jsp" class="font-semibold text-gray-100 text-sm/6 hover:text-red-500">Contact us</a>
                <a href="/blog.jsp" class="font-semibold text-gray-100 text-sm/6 hover:text-red-500">Blogs</a>
            </div>
            <div class="hidden lg:flex lg:flex-1 lg:justify-end">
                <c:if test="${ empty user}">
                    <a href="/login.jsp" class="font-semibold text-gray-100 text-sm/6 hover:text-red-500">Sign in <span aria-hidden="true">&rarr;</span></a>
                </c:if>
                <c:if test="${not empty user}">
                    <a href="/profiledefault.jsp" class="flex items-center font-light text-gray-100 text-md"><p>Welcome</p> <span class="text-red-500">.   ${user.getUsername()}</span><img class="w-auto h-10 ml-2 rounded-full" src="img/${user.getImageUrl()}"></a>
                </c:if>
            </div>
        </nav>
        <!-- Mobile menu, show/hide based on menu open state. -->
        <div class="lg:hidden" role="dialog" aria-modal="true">
            <!-- Background backdrop, show/hide based on slide-over state. -->
            <div class="fixed inset-0 z-50"></div>
            <div class="fixed inset-y-0 right-0 z-50 w-full px-6 py-6 overflow-y-auto bg-white sm:max-w-sm sm:ring-1 sm:ring-gray-900/10">
                <div class="flex items-center justify-between">
                    <a href="#" class="-m-1.5 p-1.5">
                        <span class="sr-only">Your Company</span>
                        <img class="w-auto h-8" src="https://tailwindui.com/plus/img/logos/mark.svg?color=indigo&shade=600" alt="">
                    </a>
                    <button type="button" class="-m-2.5 rounded-md p-2.5 text-gray-700">
                        <span class="sr-only">Close menu</span>
                        <svg class="size-6" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" aria-hidden="true" data-slot="icon">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M6 18 18 6M6 6l12 12" />
                        </svg>
                    </button>
                </div>
                <div class="flow-root mt-6">
                    <div class="-my-6 divide-y divide-gray-500/10">
                        <div class="py-6 space-y-2">
                            <a href="#" class="block px-3 py-2 -mx-3 font-semibold text-gray-900 rounded-lg text-base/7 hover:bg-gray-50">Product</a>
                            <a href="#" class="block px-3 py-2 -mx-3 font-semibold text-gray-900 rounded-lg text-base/7 hover:bg-gray-50">Features</a>
                            <a href="#" class="block px-3 py-2 -mx-3 font-semibold text-gray-900 rounded-lg text-base/7 hover:bg-gray-50">Marketplace</a>
                            <a href="#" class="block px-3 py-2 -mx-3 font-semibold text-gray-900 rounded-lg text-base/7 hover:bg-gray-50">Company</a>
                        </div>
                        <div class="py-6">
                            <a href="/login.jsp" class="-mx-3 block rounded-lg px-3 py-2.5 text-base/7 font-semibold text-gray-900 hover:bg-gray-50">Log in</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="relative px-6 isolate pt-14 lg:px-8">
        <div class="absolute inset-x-0 overflow-hidden -top-40 -z-10 transform-gpu blur-3xl sm:-top-80" aria-hidden="true">
            <div class="relative left-[calc(50%-11rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 rotate-[30deg] bg-gradient-to-tr from-[#ff80b5] to-[#9089fc] opacity-30 sm:left-[calc(50%-30rem)] sm:w-[72.1875rem]" style="clip-path: polygon(74.1% 44.1%, 100% 61.6%, 97.5% 26.9%, 85.5% 0.1%, 80.7% 2%, 72.5% 32.5%, 60.2% 62.4%, 52.4% 68.1%, 47.5% 58.3%, 45.2% 34.5%, 27.5% 76.7%, 0.1% 64.9%, 17.9% 100%, 27.6% 76.8%, 76.1% 97.7%, 74.1% 44.1%)"></div>
        </div>
        <div class="max-w-2xl py-32 mx-auto sm:py-48 lg:py-42">
            <div class="hidden sm:mb-8 sm:flex sm:justify-center">
                <div class="relative px-3 py-1 text-gray-100 rounded-full text-sm/6 ring-1 ring-gray-100 hover:ring-red-900/20">
                    Contact with us <a href="/contact.jsp" class="font-semibold text-red-500 hover:underline"><span class="absolute inset-0" aria-hidden="true"></span>   Read more <span aria-hidden="true">&rarr;</span></a>
                </div>
            </div>
            <div class="text-center">
                <h1 class="text-5xl font-semibold tracking-tight text-gray-200 text-balance sm:text-7xl">Discover new flavors from dishes</h1>
                <p class="mt-8 text-lg font-medium text-gray-300 text-pretty sm:text-xl/8">Discover pizzas with a crispy crust and fresh, delicious toppings. Every bite is a delightful experience, bringing perfect flavors from the oven to your table.</p>
                <div class="flex items-center justify-center mt-10 gap-x-6">
                    <a href="#" class="rounded-md bg-red-500 px-3.5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-red-600 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Get started</a>
                    <a href="#" class="px-2 py-2 font-semibold text-gray-100 transition-all rounded-md text-sm/6 hover:bg-white hover:text-gray-900">Order Now <span aria-hidden="true">&rarr;</span></a>
                </div>
            </div>
        </div>
        <div class="absolute inset-x-0 top-[calc(100%-13rem)] -z-10 transform-gpu overflow-hidden blur-3xl sm:top-[calc(100%-30rem)]" aria-hidden="true">
            <div class="relative left-[calc(50%+3rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 bg-gradient-to-tr from-[#ff80b5] to-[#9089fc] opacity-30 sm:left-[calc(50%+36rem)] sm:w-[72.1875rem]" style="clip-path: polygon(74.1% 44.1%, 100% 61.6%, 97.5% 26.9%, 85.5% 0.1%, 80.7% 2%, 72.5% 32.5%, 60.2% 62.4%, 52.4% 68.1%, 47.5% 58.3%, 45.2% 34.5%, 27.5% 76.7%, 0.1% 64.9%, 17.9% 100%, 27.6% 76.8%, 76.1% 97.7%, 74.1% 44.1%)"></div>
        </div>
    </div>
    <div class="bg-white">
        <div class="grid items-center max-w-2xl grid-cols-1 px-4 py-24 mx-auto gap-x-8 gap-y-16 sm:px-6 sm:py-32 lg:max-w-7xl lg:grid-cols-2 lg:px-8">
            <div>
                <h2 class="text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">Key Features of Our Pizza</h2>
                <p class="mt-4 text-gray-500">Pizza is the perfect blend of crispy crust, gooey cheese, and fresh toppings. From classic to creative flavors, our pizzas are baked to perfection and served hot. Perfect for family meals or parties—taste the joy today!</p>

                <dl class="grid grid-cols-1 mt-16 gap-x-6 gap-y-10 sm:grid-cols-2 sm:gap-y-16 lg:gap-x-8">
                    <div class="pt-4 border-t border-gray-200">
                        <dt class="font-medium text-gray-900">Crust</dt>
                        <dd class="mt-2 text-sm text-gray-500">A perfectly baked, golden, crispy crust that stays light and airy.</dd>
                    </div>
                    <div class="pt-4 border-t border-gray-200">
                        <dt class="font-medium text-gray-900">Cheese</dt>
                        <dd class="mt-2 text-sm text-gray-500">Rich, gooey cheese that stretches and melts in every bite.
                        </dd>
                    </div>
                    <div class="pt-4 border-t border-gray-200">
                        <dt class="font-medium text-gray-900">Fresh</dt>
                        <dd class="mt-2 text-sm text-gray-500">Hand-picked vegetables, meats, and herbs for maximum flavor.</dd>
                    </div>
                    <div class="pt-4 border-t border-gray-200">
                        <dt class="font-medium text-gray-900">Toppings</dt>
                        <dd class="mt-2 text-sm text-gray-500">Endless combinations of classic and creative options to suit every taste.</dd>
                    </div>
                    <div class="pt-4 border-t border-gray-200">
                        <dt class="font-medium text-gray-900">Stone-Baked</dt>
                        <dd class="mt-2 text-sm text-gray-500">Each pizza is baked in a traditional stone oven for an irresistible smoky aroma.</dd>
                    </div>
                    <div class="pt-4 border-t border-gray-200">
                        <dt class="font-medium text-gray-900">Customizable</dt>
                        <dd class="mt-2 text-sm text-gray-500">From gluten-free to vegan options, there is a pizza for every preference.</dd>
                    </div>
                </dl>
            </div>
            <div class="grid grid-cols-2 grid-rows-2 gap-4 sm:gap-6 lg:gap-8">
                <img src="/img/pizza4.jpg" alt="Walnut card tray with white powder coated steel divider and 3 punchout holes." class="bg-gray-100 rounded-lg">
                <img src="/img/pizza2.jpg" alt="Top down view of walnut card tray with embedded magnets and card groove." class="bg-gray-100 rounded-lg mt-12">
                <img src="/img/pizza2.jpg" alt="Side of walnut card tray with card groove and recessed card area." class="bg-gray-100 rounded-lg">
                <img src="/img/pizza4.jpg" alt="Walnut card tray filled with cards and card angled in dedicated groove." class="bg-gray-100 rounded-lg">
            </div>
        </div>
    </div>
    <div class="font-[sans-serif] py-10">
        <div class="grid lg:grid-cols-4 sm:grid-cols-2 gap-x-6 gap-y-12 divide-x divide-gray-500">
            <div class="text-center">
                <ion-icon class="text-4xl text-white inline-block" name="people-outline"></ion-icon>
                <h3 class="text-3xl font-extrabold text-red-500 mt-5">4K+</h3>
                <p class="text-base text-gray-100 font-semibold mt-3">Unique Visitors</p>
            </div>
            <div class="text-center">
                <ion-icon class="text-4xl text-white inline-block" name="stats-chart-outline"></ion-icon>
                <h3 class="text-3xl font-extrabold text-red-500 mt-5">10K+</h3>
                <p class="text-base text-gray-100 font-semibold mt-3">Total Sales</p>
            </div>
            <div class="text-center">
                <ion-icon class="text-4xl text-white inline-block" name="restaurant-outline"></ion-icon>
                <h3 class="text-3xl font-extrabold text-red-500 mt-5">3.5K+</h3>
                <p class="text-base text-gray-100 font-semibold mt-3">Customer Satisfaction</p>
            </div>
            <div class="text-center">
                <ion-icon class="text-4xl text-white inline-block" name="time-outline"></ion-icon>
                <h3 class="text-3xl font-extrabold text-red-500 mt-5">600+</h3>
                <p class="text-base text-gray-100 font-semibold mt-3">System Uptime (in hours)</p>
            </div>
        </div>
    </div>
    <div class="py-6 bg-white sm:py-8">
        <div class="px-6 mx-auto max-w-7xl lg:px-8">
            <h2 class="font-semibold text-center text-gray-900 text-lg/8 text-gray-600">Trusted by the world, it is the most famous brand of pizza</h2>
            <div class="grid items-center max-w-lg grid-cols-4 mx-auto mt-10 gap-x-6 gap-y-10 sm:max-w-xl sm:grid-cols-6 sm:gap-x-7 lg:mx-0 lg:max-w-none lg:grid-cols-5">
                <img class="object-contain w-full col-span-2 max-h-13 lg:col-span-1" src="/img/dominopizza_logo.png" alt="Transistor" width="158" height="48">
                <img class="object-contain w-full col-span-2 max-h-13 lg:col-span-1" src="https://logos-world.net/wp-content/uploads/2021/10/Pizza-Hut-Symbol.png" alt="Reform" width="158" height="48">
                <img class="object-contain w-full col-span-2 max-h-13 lg:col-span-1" src="/img/thecompanypizza_logo.webp" alt="Tuple" width="158" height="48">
                <img class="object-contain w-full col-span-2 max-h-13 sm:col-start-2 lg:col-span-1" src="/img/SimpleMonpizza_logo.png" alt="SavvyCal" width="158" height="48">
                <img class="object-contain w-full col-span-2 col-start-2 max-h-13  sm:col-start-auto lg:col-span-1" src="/img/junospizza_logo.jpg" alt="Statamic" width="158" height="48">
            </div>
        </div>
    </div>
    <div class=" px-4 py-12 font-[sans-serif]">
        <div class="max-w-6xl mx-auto">
            <h2 class="text-gray-100 sm:text-4xl text-2xl font-extrabold text-center mb-16">Discover Our Services</h2>
            <div class="grid lg:grid-cols-3 md:grid-cols-2 max-md:max-w-lg mx-auto gap-8">
                <div class="p-6 flex gap-6 bg-white rounded-lg shadow-md hover:shadow-lg transition-all">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="w-12 h-12 bg-gray-100 p-3 rounded-md shrink-0" viewBox="0 0 32 32">
                        <path d="M28.068 12h-.128a.934.934 0 0 1-.864-.6.924.924 0 0 1 .2-1.01l.091-.091a2.938 2.938 0 0 0 0-4.147l-1.511-1.51a2.935 2.935 0 0 0-4.146 0l-.091.091A.956.956 0 0 1 20 4.061v-.129A2.935 2.935 0 0 0 17.068 1h-2.136A2.935 2.935 0 0 0 12 3.932v.129a.956.956 0 0 1-1.614.668l-.086-.091a2.935 2.935 0 0 0-4.146 0l-1.516 1.51a2.938 2.938 0 0 0 0 4.147l.091.091a.935.935 0 0 1 .185 1.035.924.924 0 0 1-.854.579h-.128A2.935 2.935 0 0 0 1 14.932v2.136A2.935 2.935 0 0 0 3.932 20h.128a.934.934 0 0 1 .864.6.924.924 0 0 1-.2 1.01l-.091.091a2.938 2.938 0 0 0 0 4.147l1.51 1.509a2.934 2.934 0 0 0 4.147 0l.091-.091a.936.936 0 0 1 1.035-.185.922.922 0 0 1 .579.853v.129A2.935 2.935 0 0 0 14.932 31h2.136A2.935 2.935 0 0 0 20 28.068v-.129a.956.956 0 0 1 1.614-.668l.091.091a2.935 2.935 0 0 0 4.146 0l1.511-1.509a2.938 2.938 0 0 0 0-4.147l-.091-.091a.935.935 0 0 1-.185-1.035.924.924 0 0 1 .854-.58h.128A2.935 2.935 0 0 0 31 17.068v-2.136A2.935 2.935 0 0 0 28.068 12ZM29 17.068a.933.933 0 0 1-.932.932h-.128a2.956 2.956 0 0 0-2.083 5.028l.09.091a.934.934 0 0 1 0 1.319l-1.511 1.509a.932.932 0 0 1-1.318 0l-.09-.091A2.957 2.957 0 0 0 18 27.939v.129a.933.933 0 0 1-.932.932h-2.136a.933.933 0 0 1-.932-.932v-.129a2.951 2.951 0 0 0-5.028-2.082l-.091.091a.934.934 0 0 1-1.318 0l-1.51-1.509a.934.934 0 0 1 0-1.319l.091-.091A2.956 2.956 0 0 0 4.06 18h-.128A.933.933 0 0 1 3 17.068v-2.136A.933.933 0 0 1 3.932 14h.128a2.956 2.956 0 0 0 2.083-5.028l-.09-.091a.933.933 0 0 1 0-1.318l1.51-1.511a.932.932 0 0 1 1.318 0l.09.091A2.957 2.957 0 0 0 14 4.061v-.129A.933.933 0 0 1 14.932 3h2.136a.933.933 0 0 1 .932.932v.129a2.956 2.956 0 0 0 5.028 2.082l.091-.091a.932.932 0 0 1 1.318 0l1.51 1.511a.933.933 0 0 1 0 1.318l-.091.091A2.956 2.956 0 0 0 27.94 14h.128a.933.933 0 0 1 .932.932Z" data-original="#000000" />
                        <path d="M16 9a7 7 0 1 0 7 7 7.008 7.008 0 0 0-7-7Zm0 12a5 5 0 1 1 5-5 5.006 5.006 0 0 1-5 5Z" data-original="#000000" />
                    </svg>
                    <div>
                        <h3 class="text-gray-800 text-xl font-semibold mb-3">Quality</h3>
                        <p class="text-gray-600 text-sm">Tailor our product to suit your needs Expand your reach with our global network.</p>
                    </div>
                </div>

                <div class="p-6 flex gap-6 bg-white rounded-lg shadow-md hover:shadow-lg transition-all">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="w-12 h-12 bg-gray-100 p-3 rounded-md shrink-0" viewBox="0 0 682.667 682.667">
                        <defs>
                            <clipPath id="a" clipPathUnits="userSpaceOnUse">
                                <path d="M0 512h512V0H0Z" data-original="#000000" />
                            </clipPath>
                        </defs>
                        <g fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="40" clip-path="url(#a)" transform="matrix(1.33 0 0 -1.33 0 682.667)">
                            <path d="M256 492 60 410.623v-98.925C60 183.674 137.469 68.38 256 20c118.53 48.38 196 163.674 196 291.698v98.925z" data-original="#000000" />
                            <path d="M178 271.894 233.894 216 334 316.105" data-original="#000000" />
                        </g>
                    </svg>
                    <div>
                        <h3 class="text-gray-800 text-xl font-semibold mb-3">Security</h3>
                        <p class="text-gray-600 text-sm">Your data is protected by the latest security measures.</p>
                    </div>
                </div>

                <div class="p-6 flex gap-6 bg-white rounded-lg shadow-md hover:shadow-lg transition-all">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="w-12 h-12 bg-gray-100 p-3 rounded-md shrink-0" viewBox="0 0 512.001 512.001">
                        <path d="M271.029 0c-33.091 0-61 27.909-61 61s27.909 61 61 61 60-27.909 60-61-26.909-61-60-61zm66.592 122c-16.485 18.279-40.096 30-66.592 30-26.496 0-51.107-11.721-67.592-30-14.392 15.959-23.408 36.866-23.408 60v15c0 8.291 6.709 15 15 15h151c8.291 0 15-6.709 15-15v-15c0-23.134-9.016-44.041-23.408-60zM144.946 460.404 68.505 307.149c-7.381-14.799-25.345-20.834-40.162-13.493l-19.979 9.897c-7.439 3.689-10.466 12.73-6.753 20.156l90 180c3.701 7.423 12.704 10.377 20.083 6.738l19.722-9.771c14.875-7.368 20.938-25.417 13.53-40.272zM499.73 247.7c-12.301-9-29.401-7.2-39.6 3.9l-82 100.8c-5.7 6-16.5 9.6-22.2 9.6h-69.901c-8.401 0-15-6.599-15-15s6.599-15 15-15h60c16.5 0 30-13.5 30-30s-13.5-30-30-30h-78.6c-7.476 0-11.204-4.741-17.1-9.901-23.209-20.885-57.949-30.947-93.119-22.795-19.528 4.526-32.697 12.415-46.053 22.993l-.445-.361-21.696 19.094L174.28 452h171.749c28.2 0 55.201-13.5 72.001-36l87.999-126c9.9-13.201 7.2-32.399-6.299-42.3z" data-original="#000000" />
                    </svg>
                    <div>
                        <h3 class="text-gray-800 text-xl font-semibold mb-3">Support</h3>
                        <p class="text-gray-600 text-sm">Tailor our product to suit your needs 24/7 customer support for all your inquiries.</p>
                    </div>
                </div>

                <div class="p-6 flex gap-6 bg-white rounded-lg shadow-md hover:shadow-lg transition-all">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="w-12 h-12 bg-gray-100 p-3 rounded-md shrink-0" viewBox="0 0 24 24">
                        <g fill-rule="evenodd" clip-rule="evenodd">
                            <path d="M17.03 8.97a.75.75 0 0 1 0 1.06l-4.2 4.2a.75.75 0 0 1-1.154-.114l-1.093-1.639L8.03 15.03a.75.75 0 0 1-1.06-1.06l3.2-3.2a.75.75 0 0 1 1.154.114l1.093 1.639L15.97 8.97a.75.75 0 0 1 1.06 0z" data-original="#000000" />
                            <path d="M13.75 9.5a.75.75 0 0 1 .75-.75h2a.75.75 0 0 1 .75.75v2a.75.75 0 0 1-1.5 0v-1.25H14.5a.75.75 0 0 1-.75-.75z" data-original="#000000" />
                            <path d="M3.095 3.095C4.429 1.76 6.426 1.25 9 1.25h6c2.574 0 4.57.51 5.905 1.845C22.24 4.429 22.75 6.426 22.75 9v6c0 2.574-.51 4.57-1.845 5.905C19.571 22.24 17.574 22.75 15 22.75H9c-2.574 0-4.57-.51-5.905-1.845C1.76 19.571 1.25 17.574 1.25 15V9c0-2.574.51-4.57 1.845-5.905zm1.06 1.06C3.24 5.071 2.75 6.574 2.75 9v6c0 2.426.49 3.93 1.405 4.845.916.915 2.419 1.405 4.845 1.405h6c2.426 0 3.93-.49 4.845-1.405.915-.916 1.405-2.419 1.405-4.845V9c0-2.426-.49-3.93-1.405-4.845C18.929 3.24 17.426 2.75 15 2.75H9c-2.426 0-3.93.49-4.845 1.405z" data-original="#000000" />
                        </g>
                    </svg>
                    <div>
                        <h3 class="text-gray-800 text-xl font-semibold mb-3">Express delivery</h3>
                        <p class="text-gray-600 text-sm">Experience blazing-fast performance with our product.</p>
                    </div>
                </div>

                <div class="p-6 flex gap-6 bg-white rounded-lg shadow-md hover:shadow-lg transition-all">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="w-12 h-12 bg-gray-100 p-3 rounded-md shrink-0" viewBox="0 0 504.69 504.69">
                        <path d="M252.343 262.673c-49.32 0-89.447-40.127-89.447-89.447s40.127-89.447 89.447-89.447 89.447 40.127 89.447 89.447-40.121 89.447-89.447 89.447zm0-158.235c-37.926 0-68.787 30.861-68.787 68.787s30.861 68.787 68.787 68.787 68.787-30.861 68.787-68.787-30.855-68.787-68.787-68.787z" data-original="#000000" />
                        <path d="M391.787 405.309c-5.645 0-10.253-4.54-10.325-10.201-.883-70.306-58.819-127.503-129.15-127.503-49.264 0-93.543 27.405-115.561 71.52-8.724 17.473-13.269 36.31-13.517 55.988-.072 5.702-4.757 10.273-10.459 10.201s-10.273-4.757-10.201-10.459c.289-22.814 5.568-44.667 15.691-64.955 25.541-51.164 76.907-82.95 134.047-82.95 81.581 0 148.788 66.349 149.81 147.905.072 5.702-4.494 10.392-10.201 10.459-.046-.005-.087-.005-.134-.005z" data-original="#000000" />
                        <path d="M252.343 463.751c-116.569 0-211.408-94.834-211.408-211.408 0-116.569 94.839-211.408 211.408-211.408 116.574 0 211.408 94.839 211.408 211.408 0 116.574-94.834 211.408-211.408 211.408zm0-402.156c-105.18 0-190.748 85.568-190.748 190.748s85.568 190.748 190.748 190.748 190.748-85.568 190.748-190.748S357.523 61.595 252.343 61.595zM71.827 90.07 14.356 32.599c-4.034-4.034-4.034-10.573 0-14.607 4.029-4.034 10.573-4.034 14.607 0l57.466 57.471c4.034 4.034 3.951 10.49 0 14.607-3.792 3.951-11.039 3.698-14.602 0z" data-original="#000000" />
                        <path d="M14.717 92.254a10.332 10.332 0 0 1-10.299-9.653L.023 15.751a10.317 10.317 0 0 1 2.929-7.908 10.2 10.2 0 0 1 7.851-3.089L77.56 7.796c5.697.258 10.108 5.093 9.85 10.79s-5.041 10.154-10.79 9.85l-55.224-2.521 3.641 55.327c.377 5.692-3.936 10.614-9.628 10.986a7.745 7.745 0 0 1-.692.026zm403.541-2.184c-4.256-3.796-4.034-10.573 0-14.607l58.116-58.116c4.034-4.034 10.573-4.034 14.607 0s4.034 10.573 0 14.607L432.864 90.07c-4.085 3.951-9.338 4.7-14.606 0z" data-original="#000000" />
                        <path d="M489.974 92.254a9.85 9.85 0 0 1-.687-.021c-5.697-.372-10.01-5.294-9.633-10.986l3.641-55.327-55.224 2.515c-5.511.238-10.526-4.147-10.79-9.85-.258-5.702 4.153-10.531 9.85-10.79l66.757-3.042c2.934-.134 5.79.992 7.851 3.089s3.12 4.974 2.929 7.908l-4.401 66.85c-.361 5.465-4.896 9.654-10.293 9.654zM11.711 489.339c-3.791-4.266-4.034-10.573 0-14.607l60.115-60.11c4.029-4.034 10.578-4.034 14.607 0 4.034 4.034 4.034 10.573 0 14.607l-60.115 60.11c-3.827 3.884-11.156 3.884-14.607 0z" data-original="#000000" />
                        <path d="M10.327 499.947a10.33 10.33 0 0 1-7.376-3.104 10.312 10.312 0 0 1-2.929-7.902l4.401-66.85c.372-5.697 5.191-10.036 10.986-9.633 5.692.377 10.005 5.294 9.628 10.986l-3.641 55.332 55.224-2.515c5.645-.191 10.531 4.153 10.79 9.85.258 5.697-4.153 10.526-9.85 10.79l-66.763 3.037c-.155.004-.31.009-.47.009zm465.639-13.01-57.708-57.708c-4.034-4.034-4.034-10.573 0-14.607s10.573-4.034 14.607 0l57.708 57.708c4.034 4.034 3.962 10.5 0 14.607-3.817 3.951-10.062 3.951-14.607 0z" data-original="#000000" />
                        <path d="M494.359 499.947c-.155 0-.315-.005-.47-.01l-66.757-3.042c-5.702-.263-10.108-5.088-9.85-10.79.263-5.702 5.113-9.984 10.79-9.85l55.219 2.515-3.641-55.332c-.372-5.692 3.941-10.609 9.633-10.986 5.625-.398 10.609 3.946 10.986 9.633l4.401 66.85a10.33 10.33 0 0 1-2.929 7.902 10.323 10.323 0 0 1-7.382 3.11z" data-original="#000000" />
                    </svg>
                    <div>
                        <h3 class="text-gray-800 text-xl font-semibold mb-3">Global's acknowledge</h3>
                        <p class="text-gray-600 text-sm">Tailor our product to suit your needs Expand your reach with our global network.</p>
                    </div>
                </div>

                <div class="p-6 flex gap-6 bg-white rounded-lg shadow-md hover:shadow-lg transition-all">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="w-12 h-12 bg-gray-100 p-3 rounded-md shrink-0" viewBox="0 0 682.667 682.667">
                        <defs>
                            <clipPath id="a" clipPathUnits="userSpaceOnUse">
                                <path d="M0 512h512V0H0Z" data-original="#000000" />
                            </clipPath>
                        </defs>
                        <g fill="none" stroke="currentColor" stroke-miterlimit="10" stroke-width="30" clip-path="url(#a)" transform="matrix(1.33 0 0 -1.33 0 682.667)">
                            <path d="M226 15v60c0 16.568-13.432 30-30 30H76c-16.568 0-30-13.432-30-30V15Zm-45 165c0-24.853-20.147-45-45-45s-45 20.147-45 45 20.147 45 45 45 45-20.147 45-45ZM466 15v60c0 16.568-13.432 30-30 30H316c-16.568 0-30-13.432-30-30V15Zm-45 165c0-24.853-20.147-45-45-45s-45 20.147-45 45 20.147 45 45 45 45-20.147 45-45Zm-75 167v-50.294L286 347h-60.002L166 296.706V347h-15c-41.421 0-75 33.579-75 75s33.579 75 75 75h210c41.421 0 75-33.579 75-75s-33.579-75-75-75Zm-105 75h30m-90 0h30m90 0h30" data-original="#000000" />
                        </g>
                    </svg>
                    <div>
                        <h3 class="text-gray-800 text-xl font-semibold mb-3">Convienience</h3>
                        <p class="text-gray-600 text-sm">Tailor our product to suit your needs Seamless communication for your team.</p>
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
</body>

</html>
