<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <link href="css/marketplace.css" rel="stylesheet">
    <script src="https://cdn.tailwindcss.com"></script>

    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Inconsolata:wght@200;300;400;500;600;700;800;900&display=swap"
          rel="stylesheet">
    <title>Kaicourses | Login</title>

</head>
<script src="js/login.js"></script>
<body>
<div class="flex flex-wrap w-full">
    <div class="flex flex-col w-full md:w-1/2 lg:w-2/5">
        <div class="flex justify-center pt-6 md:-mb-24 md:justify-start md:pl-12">
            <a href="#" class="pb-2 text-2xl font-bold text-gray-900 border-b-4 border-b-blue-700"> Kaicourses </a>
        </div>
        <div class="flex flex-col justify-center px-6 pt-8 my-auto sm:px-24 md:justify-start md:px-8 md:pt-0 lg:px-12">
            <p class="mt-16 text-3xl font-bold text-center">Welcome</p>
            <p class="mb-10 text-center ">Login to access your account.</p>

            <div class="flex flex-col justify-center">
                <div class="relative py-4 sm:max-w-xl sm:mx-auto">
                    <div
                            class="absolute inset-0 transform shadow-lg -skew-y-8 bg-gradient-to-r from-pink-300 to-blue-500 sm:skew-y-0 sm:-rotate-6 sm:rounded-3xl">
                    </div>
                    <div class="relative px-4 py-10 bg-white shadow-lg sm:rounded-3xl sm:p-20">

                        <div class="max-w-md mx-auto">
                            <div>
                                <h1 class="text-2xl font-semibold">Here!</h1>
                            </div>
                            <form onsubmit="loginPostChecking()" class="divide-y divide-gray-200">
                                <div class="py-8 space-y-3 text-base leading-6 text-gray-700 sm:text-lg sm:leading-1">
                                    <div class="relative py-1">
                                        <input id="txtUsername" name="username" type="text" class="w-full h-10 text-gray-900 placeholder-transparent border-b-2 border-gray-300 peer focus:outline-none focus:borer-rose-600" placeholder="Email address" />
                                        <label for="txtUsername" class="absolute left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-3.5 peer-focus:text-gray-600 peer-focus:text-sm">Username</label>
                                    </div>
                                    <div class="relative py-1">
                                        <input id="txtPassword" name="password" type="password" class="w-full h-10 text-gray-900 placeholder-transparent border-b-2 border-gray-300 peer focus:outline-none focus:borer-rose-600" placeholder="Password" />
                                        <label for="txtPassword" class="absolute left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-3.5 peer-focus:text-gray-600 peer-focus:text-sm">Password</label>
                                    </div>
                                    <div class="relative">
                                        <button type="submit" class="px-4 py-2 text-white transition-all bg-blue-600 rounded-md hover:bg-blue-700">Sign in</button>
                                    </div>
                                    <div id="messageLoginFailed" class="text-red-500 text-sm"></div>
                                </div>
                            </form>
                        </div>

                        <div class="flex justify-center w-full">
                            <button class="bg-gray-100 flex items-center justify-center px-4 py-2 border-gray-600 rounded-md transition hover:border-transparent hover:bg-black hover:text-white focus:ring-2">
                                <svg class="w-6 h-6 mr-2" xmlns="http://www.w3.org/2000/svg" width="800px" height="800px" viewBox="-0.5 0 48 48" version="1.1"> <title>Google-color</title> <desc>Created with Sketch.</desc> <defs> </defs> <g id="Icons" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"> <g id="Color-" transform="translate(-401.000000, -860.000000)"> <g id="Google" transform="translate(401.000000, 860.000000)"> <path d="M9.82727273,24 C9.82727273,22.4757333 10.0804318,21.0144 10.5322727,19.6437333 L2.62345455,13.6042667 C1.08206818,16.7338667 0.213636364,20.2602667 0.213636364,24 C0.213636364,27.7365333 1.081,31.2608 2.62025,34.3882667 L10.5247955,28.3370667 C10.0772273,26.9728 9.82727273,25.5168 9.82727273,24" id="Fill-1" fill="#FBBC05"> </path> <path d="M23.7136364,10.1333333 C27.025,10.1333333 30.0159091,11.3066667 32.3659091,13.2266667 L39.2022727,6.4 C35.0363636,2.77333333 29.6954545,0.533333333 23.7136364,0.533333333 C14.4268636,0.533333333 6.44540909,5.84426667 2.62345455,13.6042667 L10.5322727,19.6437333 C12.3545909,14.112 17.5491591,10.1333333 23.7136364,10.1333333" id="Fill-2" fill="#EB4335"> </path> <path d="M23.7136364,37.8666667 C17.5491591,37.8666667 12.3545909,33.888 10.5322727,28.3562667 L2.62345455,34.3946667 C6.44540909,42.1557333 14.4268636,47.4666667 23.7136364,47.4666667 C29.4455,47.4666667 34.9177955,45.4314667 39.0249545,41.6181333 L31.5177727,35.8144 C29.3995682,37.1488 26.7323182,37.8666667 23.7136364,37.8666667" id="Fill-3" fill="#34A853"> </path> <path d="M46.1454545,24 C46.1454545,22.6133333 45.9318182,21.12 45.6113636,19.7333333 L23.7136364,19.7333333 L23.7136364,28.8 L36.3181818,28.8 C35.6879545,31.8912 33.9724545,34.2677333 31.5177727,35.8144 L39.0249545,41.6181333 C43.3393409,37.6138667 46.1454545,31.6490667 46.1454545,24" id="Fill-4" fill="#4285F4"> </path> </g> </g> </g> </svg>
                                <span>Continue with Google</span>
                            </button>
                        </div>

                    </div>
                </div>
            </div>
            <div class="pt-10 text-center ">
                <p class="whitespace-nowrap">
                    Don't have an account?
                    <a href="register.jsp" class="font-semibold underline hover:text-indigo-700"> Register here. </a>
                </p>
            </div>
        </div>
    </div>
    <div class="hidden bg-black shadow-2xl pointer-events-none select-none md:block md:w-1/2 lg:w-3/5">
        <img class="object-cover w-full h-screen opacity-90" src="https://images.squarespace-cdn.com/content/v1/62c8d4057e4961711a885468/a43535e7-ab2a-402f-939f-b114cf0cbaf2/Peace+Pizza+-172.jpg" />
    </div>
</div>

</body>
</html>
