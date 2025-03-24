<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <link href="/css/contact.css" rel="stylesheet">
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Inconsolata:wght@200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <title>Kaicourses | Contact</title>
</head>
<body>
<div>
    <header>
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
                <a href="/productlist" class="font-semibold text-gray-900 text-sm/6 hover:text-red-500">Marketplace</a>
                <div class="dropdown">
                    <a href="#" class="font-semibold text-gray-900 text-sm/6 hover:text-red-500">Categories</a>
                    <ul class="dropdown-menu">
                        <li><a href="#" class="dropdown-item hover:text-red-500">Category 1</a></li>
                        <li><a href="#" class="dropdown-item hover:text-red-500">Category 2</a></li>
                        <li><a href="#" class="dropdown-item hover:text-red-500">Category 3</a></li>
                    </ul>
                </div>
                <a href="#" class="font-semibold text-gray-900 text-sm/6 hover:text-red-500">Reviews</a>
                <a href="/contact.jsp" class="font-semibold text-gray-900 text-sm/6 hover:text-red-500">Contact us</a>
                <a href="/blog.jsp" class="font-semibold text-gray-900 text-sm/6 hover:text-red-500">Blogs</a>
            </div>
            <div class="hidden lg:flex lg:flex-1 lg:justify-end">
                <a href="/login.jsp" class="font-semibold text-gray-900 text-sm/6 hover:text-red-500">Sign in <span aria-hidden="true">&rarr;</span></a>
            </div>
        </nav>
    </header>
    <div class="max-w-6xl mx-auto font-[sans-serif] flex items-center border mt-7 rounded-md shadow-indigo-500 shadow-lg mb-10">
        <div
                class="grid md:grid-cols-2 gap-16 items-center relative overflow-hidden p-8 before:absolute before:right-0 before:w-[300px] before:bg-blue-400 before:h-full max-md:before:hidden">
            <div>
                <h2 class="text-3xl font-bold text-gray-800">Contact with us</h2>
                <p class="mt-4 text-sm leading-relaxed text-gray-500">Have a specific inquiry or looking to explore new opportunities? Our
                    experienced team is ready to engage with you.</p>

                <form>
                    <div class="mt-8 space-y-4">
                        <input type="text" placeholder="First Name"
                               class="w-full px-2 py-3 text-sm text-gray-800 bg-white border-b border-gray-300 outline-none focus:border-blue-600" />
                        <input type="text" placeholder="Last Name"
                               class="w-full px-2 py-3 text-sm text-gray-800 bg-white border-b border-gray-300 outline-none focus:border-blue-600" />
                        <input type="text" placeholder="Email"
                               class="w-full px-2 py-3 text-sm text-gray-800 bg-white border-b border-gray-300 outline-none focus:border-blue-600" />
                        <div class="grid grid-cols-2 gap-6">
                            <input type="text" placeholder="Phone No."
                                   class="w-full px-2 py-3 text-sm text-gray-800 bg-white border-b border-gray-300 outline-none focus:border-blue-600" />

                            <input type="date" placeholder="Your birthday"
                                   class="w-full px-2 py-3 text-sm text-gray-800 bg-white border-b border-gray-300 outline-none focus:border-blue-600" />
                        </div>
                        <input type="text" placeholder="Address"
                               class="w-full px-2 py-3 text-sm text-gray-800 bg-white border-b border-gray-300 outline-none focus:border-blue-600" />
                        <textarea placeholder="Write Message (optional)"
                                  class="w-full px-2 pt-3 text-sm text-gray-800 bg-white border-b border-gray-300 outline-none focus:border-blue-600"></textarea>
                    </div>

                    <button type="button"
                            class="mt-8 flex items-center justify-center text-sm w-full px-4 py-2.5 bg-blue-600 hover:bg-blue-700 text-white">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16px" height="16px" fill='#fff' class="mr-2"
                             viewBox="0 0 548.244 548.244">
                            <path fill-rule="evenodd"
                                  d="M392.19 156.054 211.268 281.667 22.032 218.58C8.823 214.168-.076 201.775 0 187.852c.077-13.923 9.078-26.24 22.338-30.498L506.15 1.549c11.5-3.697 24.123-.663 32.666 7.88 8.542 8.543 11.577 21.165 7.879 32.666L390.89 525.906c-4.258 13.26-16.575 22.261-30.498 22.338-13.923.076-26.316-8.823-30.728-22.032l-63.393-190.153z"
                                  clip-rule="evenodd" data-original="#000000" />
                        </svg>
                        Send Message
                    </button>
                </form>

                <ul class="flex flex-wrap justify-center gap-6 mt-4">
                    <li class="flex items-center text-blue-600">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16px" height="16px" fill='currentColor'
                             viewBox="0 0 479.058 479.058">
                            <path
                                    d="M434.146 59.882H44.912C20.146 59.882 0 80.028 0 104.794v269.47c0 24.766 20.146 44.912 44.912 44.912h389.234c24.766 0 44.912-20.146 44.912-44.912v-269.47c0-24.766-20.146-44.912-44.912-44.912zm0 29.941c2.034 0 3.969.422 5.738 1.159L239.529 264.631 39.173 90.982a14.902 14.902 0 0 1 5.738-1.159zm0 299.411H44.912c-8.26 0-14.971-6.71-14.971-14.971V122.615l199.778 173.141c2.822 2.441 6.316 3.655 9.81 3.655s6.988-1.213 9.81-3.655l199.778-173.141v251.649c-.001 8.26-6.711 14.97-14.971 14.97z"
                                    data-original="#000000" />
                        </svg>
                        <a href="javascript:void(0)" class="ml-3 text-sm">
                            <strong>devcldkai@gmail.com</strong>
                        </a>
                    </li>
                    <li class="flex items-center text-blue-600">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16px" height="16px" fill='currentColor'
                             viewBox="0 0 482.6 482.6">
                            <path
                                    d="M98.339 320.8c47.6 56.9 104.9 101.7 170.3 133.4 24.9 11.8 58.2 25.8 95.3 28.2 2.3.1 4.5.2 6.8.2 24.9 0 44.9-8.6 61.2-26.3.1-.1.3-.3.4-.5 5.8-7 12.4-13.3 19.3-20 4.7-4.5 9.5-9.2 14.1-14 21.3-22.2 21.3-50.4-.2-71.9l-60.1-60.1c-10.2-10.6-22.4-16.2-35.2-16.2-12.8 0-25.1 5.6-35.6 16.1l-35.8 35.8c-3.3-1.9-6.7-3.6-9.9-5.2-4-2-7.7-3.9-11-6-32.6-20.7-62.2-47.7-90.5-82.4-14.3-18.1-23.9-33.3-30.6-48.8 9.4-8.5 18.2-17.4 26.7-26.1 3-3.1 6.1-6.2 9.2-9.3 10.8-10.8 16.6-23.3 16.6-36s-5.7-25.2-16.6-36l-29.8-29.8c-3.5-3.5-6.8-6.9-10.2-10.4-6.6-6.8-13.5-13.8-20.3-20.1-10.3-10.1-22.4-15.4-35.2-15.4-12.7 0-24.9 5.3-35.6 15.5l-37.4 37.4c-13.6 13.6-21.3 30.1-22.9 49.2-1.9 23.9 2.5 49.3 13.9 80 17.5 47.5 43.9 91.6 83.1 138.7zm-72.6-216.6c1.2-13.3 6.3-24.4 15.9-34l37.2-37.2c5.8-5.6 12.2-8.5 18.4-8.5 6.1 0 12.3 2.9 18 8.7 6.7 6.2 13 12.7 19.8 19.6 3.4 3.5 6.9 7 10.4 10.6l29.8 29.8c6.2 6.2 9.4 12.5 9.4 18.7s-3.2 12.5-9.4 18.7c-3.1 3.1-6.2 6.3-9.3 9.4-9.3 9.4-18 18.3-27.6 26.8l-.5.5c-8.3 8.3-7 16.2-5 22.2.1.3.2.5.3.8 7.7 18.5 18.4 36.1 35.1 57.1 30 37 61.6 65.7 96.4 87.8 4.3 2.8 8.9 5 13.2 7.2 4 2 7.7 3.9 11 6 .4.2.7.4 1.1.6 3.3 1.7 6.5 2.5 9.7 2.5 8 0 13.2-5.1 14.9-6.8l37.4-37.4c5.8-5.8 12.1-8.9 18.3-8.9 7.6 0 13.8 4.7 17.7 8.9l60.3 60.2c12 12 11.9 25-.3 37.7-4.2 4.5-8.6 8.8-13.3 13.3-7 6.8-14.3 13.8-20.9 21.7-11.5 12.4-25.2 18.2-42.9 18.2-1.7 0-3.5-.1-5.2-.2-32.8-2.1-63.3-14.9-86.2-25.8-62.2-30.1-116.8-72.8-162.1-127-37.3-44.9-62.4-86.7-79-131.5-10.3-27.5-14.2-49.6-12.6-69.7z"
                                    data-original="#000000"></path>
                        </svg>
                        <a href="javascript:void(0)" class="ml-3 text-sm">
                            <strong>+158 996 888</strong>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="z-10 relative h-full max-md:min-h-[350px] rounded-sm">
                <iframe src="https://maps.google.com/maps?q=manhatan&t=&z=13&ie=UTF8&iwloc=&output=embed"
                        class="top-0 left-0 w-full h-full" frameborder="0"
                        allowfullscreen></iframe>
            </div>
        </div>
    </div>
    <div class="font-sans p-4 max-w-full">
        <div class="md:max-w-5xl max-w-lg mx-auto">
            <div class="grid md:grid-cols-2 gap-6">
                <div class="max-w-sm">
                    <h2 class="text-gray-600 text-3xl font-semibold mb-4 leading-10">
                        Welcome to engage in KaiPizzas <br />
                        Your Favorite Pizza, Freshly Made
                    </h2>
                </div>
                <div class="text-left">
                    <p class="mb-4 text-sm text-gray-500">
                        At KaiPizzas, we take pride in crafting the freshest, most delicious pizzas tailored to your taste. Using the finest ingredients, our pizzas are a perfect blend of flavor and quality.
                    </p>
                    <p class="text-sm text-gray-500">
                        Explore our menu filled with mouth-watering options, from classic favorites to unique creations. Whether dining in, ordering takeout, or enjoying delivery, we're here to serve you with excellence.
                    </p>
                    <button type="button" class="mt-6 px-5 py-2.5 rounded-md text-white text-sm tracking-wider font-medium border border-current outline-none bg-blue-700 hover:bg-blue-800 active:bg-blue-700">
                        Order Now
                    </button>
                </div>
            </div>

            <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-6 mt-16">
                <div>
                    <svg xmlns="http://www.w3.org/2000/svg" class="w-8 h-8" viewBox="0 0 512 512">
                        <g fill-rule="evenodd" clip-rule="evenodd">
                            <path fill="#ff405c" d="M255.997.007c-141.156 0-256 114.844-256 256 0 141.16 114.844 256 256 256 141.16 0 256.004-114.84 256.004-256C512 114.851 397.157.007 255.997.007z" data-original="#ff405c" />
                            <path fill="#d01273" d="M269.845 511.629c110.122-5.9 201.974-81.716 231.869-183.747l-99.461-99.461a12.002 12.002 0 0 0-1.223-1.135l-137.504-110.9a11.994 11.994 0 0 0-15.061 0l-137.5 110.9a12.01 12.01 0 0 0-3.788 13.337 12.008 12.008 0 0 0 3.109 4.757l39.179 39.186v101.722a11.97 11.97 0 0 0 3.796 8.758z" data-original="#d01273" />
                            <path fill="#fff" d="M350.528 224.627c-6.632 0-11.999 5.372-11.999 11.999V374.29h-35.472v-93.423c0-6.627-5.367-11.999-11.999-11.999H220.94c-6.631 0-11.999 5.372-11.999 11.999v93.423h-35.472V236.626c0-6.627-5.372-11.999-11.999-11.999h-8.983l103.509-83.484 103.514 83.484z" data-original="#ffffff" />
                        </g>
                    </svg>
                    <div class="mt-4">
                        <h3 class="text-lg font-bold text-gray-600 mb-2">Fresh Ingredients</h3>
                        <p class="text-gray-500 text-sm">
                            We use only the freshest, highest-quality ingredients to ensure every bite is packed with flavor and nutrition.
                        </p>
                    </div>
                </div>

                <div>
                    <svg xmlns="http://www.w3.org/2000/svg" class="w-8 h-8" viewBox="0 0 24 24">
                        <g data-name="Layer 2">
                            <path fill="#54d6c0" d="M23 5.675h-3.3a.825.825 0 0 0-.825.825v14.85a2.475 2.475 0 0 0 4.95 0V6.5A.825.825 0 0 0 23 5.675z" data-original="#54d6c0" />
                            <path fill="#1f95f8" d="M21.735 23.726a.744.744 0 0 1-.385.099H4.3A4.126 4.126 0 0 1 .175 19.7V2.1A1.934 1.934 0 0 1 2.1.175h16.5A1.934 1.934 0 0 1 20.525 2.1v19.943a1.771 1.771 0 0 0 1.21 1.683z" data-original="#1f95f8" />
                            <g fill="#fff" transform="matrix(1.1 0 0 1.1 -1.2 -1.2)">
                                <rect width="5.5" height="5.5" x="4.25" y="4.75" data-original="#ffffff" rx=".75" />
                                <path d="M16 6.75h-4a.75.75 0 0 1 0-1.5h4a.75.75 0 0 1 0 1.5zm0 3h-4a.75.75 0 0 1 0-1.5h4a.75.75 0 0 1 0 1.5zm0 4H5a.75.75 0 0 1 0-1.5h11a.75.75 0 0 1 0 1.5zm0 3H5a.75.75 0 0 1 0-1.5h11a.75.75 0 0 1 0 1.5zm0 3H5a.75.75 0 0 1 0-1.5h11a.75.75 0 0 1 0 1.5z" data-original="#ffffff" />
                            </g>
                        </g>
                    </svg>
                    <div class="mt-4">
                        <h3 class="text-lg font-bold text-gray-600 mb-2">Exclusive Deals</h3>
                        <p class="text-gray-500 text-sm">
                            Enjoy special discounts and offers available only at KaiPizzas. Check out our seasonal promotions today!
                        </p>
                    </div>
                </div>

                <div>
                    <svg xmlns="http://www.w3.org/2000/svg" class="w-8 h-8" viewBox="0 0 512 512">
                        <path fill="#64b5f6" d="M0 192L246.528 348.896c2.816 2.08 6.144 3.104 9.472 3.104s6.656-1.024 9.472-3.104L512 192 265.6 3.2a16.032 16.032 0 0 0-19.2 0L0 192z" data-original="#64b5f6" />
                        <path fill="#eceff1" d="M416 0H96C78.368 0 64 14.368 64 32v352c0 8.832 7.168 16 16 16h352c8.832 0 16-7.168 16-16V32c0-17.632-14.336-32-32-32z" data-original="#eceff1" />
                        <path fill="#90a4ae" d="M144 96h224c8.832 0 16-7.168 16-16s-7.168-16-16-16H144c-8.832 0-16 7.168-16 16s7.168 16 16 16zm224 32H144c-8.832 0-16 7.168-16 16s7.168 16 16 16h224c8.832 0 16-7.168 16-16s-7.168-16-16-16zm-96 64H144c-8.832 0-16 7.168-16 16s7.168 16 16 16h128c8.832 0 16-7.168 16-16s-7.168-16-16-16z" data-original="#90a4ae" />
                    </svg>
                    <div class="mt-4">
                        <h3 class="text-lg font-bold text-gray-600 mb-2">Customer Favorites</h3>
                        <p class="text-gray-500 text-sm">
                            Discover our top-rated pizzas loved by our customers. Each recipe is designed to delight your taste buds.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="max-w-6xl mx-auto bg-gray-100 p-10 rounded-xl font-sans mt-10 mb-10">
        <div>
            <h2 class="text-gray-800 text-2xl font-bold mb-4">Our Signature Pizzas</h2>
            <p class="text-gray-600 leading-relaxed text-base">
                Discover our wide range of signature pizzas, from classic Margherita to our exclusive Kaipizzas Special topped with gourmet ingredients. There's something to satisfy every craving.
            </p>
            <div class="mt-4">
                <a href="javascript:void(0);" class="text-blue-500 font-semibold hover:underline text-base">Explore our menu...</a>
            </div>
        </div>
    </div>
    <div class="max-w-6xl mx-auto bg-gray-100 p-10 rounded-xl font-sans mt-10 mb-10">
        <div>
            <h2 class="text-gray-800 text-2xl font-bold mb-4">Fast and Fresh Delivery</h2>
            <p class="text-gray-600 leading-relaxed text-base">
                Enjoy hot and fresh pizza delivered straight to your doorstep. Our dedicated team ensures your pizza arrives promptly, so you can enjoy it at its best.
            </p>
            <div class="mt-4">
                <a href="javascript:void(0);" class="text-blue-500 font-semibold hover:underline text-base">Order now...</a>
            </div>
        </div>
    </div>
    <div class="max-w-6xl mx-auto bg-gray-100 p-10 rounded-xl font-sans mt-10 mb-10">
        <div>
            <h2 class="text-gray-800 text-2xl font-bold mb-4">Special Offers and Discounts</h2>
            <p class="text-gray-600 leading-relaxed text-base">
                Stay tuned for our exclusive deals and discounts! At Kaipizzas, we love to treat our customers with irresistible offers that make every bite more enjoyable.
            </p>
            <div class="mt-4">
                <a href="javascript:void(0);" class="text-blue-500 font-semibold hover:underline text-base">Check out the latest deals...</a>
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
