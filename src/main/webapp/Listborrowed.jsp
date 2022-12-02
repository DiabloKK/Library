<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Dashboard - NiceAdmin Bootstrap Template</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/Logodhbk.jpg" rel="icon">
    <link href="assets/img/Logodhbk.jpg" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">


    <!-- Template Main CSS File -->
    <link href="assets/css/style.css" rel="stylesheet">
    <style>
        .hidden {
            display: none;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

</head>

<body>

<header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
        <a href="Dashboard" class="logo d-flex align-items-center">
            <img id="logo" src="assets/img/logodhbk.jpg" alt="Logo">
            <span class="d-none d-lg-block">Library</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div>

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">

            <li class="nav-item dropdown pe-3">

                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                    <img src="assets/img/profile.png" alt="Profile" class="rounded-circle">
                    <span class="d-none d-md-block dropdown-toggle ps-2">${sessionScope.username}</span>
                </a>

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <li class="dropdown-header">
                        <h6>${sessionScope.username}</h6>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="Profile">
                            <i class="bi bi-person"></i>
                            <span>My Profile</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="Logout">
                            <i class="bi bi-box-arrow-right"></i>
                            <span>Sign Out</span>
                        </a>
                    </li>

                </ul>
            </li>

        </ul>
    </nav>

</header>

<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link " href="Dashboard">
                <i class="bi bi-grid"></i>
                <span>Dashboard</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#manageBook-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Manage Book</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="manageBook-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="ManageBook">
                        <i class="bi bi-circle"></i><span>Books</span>
                    </a>
                </li>
                <li>
                    <a href="AddBook">
                        <i class="bi bi-circle"></i><span>New Book</span>
                    </a>
                </li>
                <li>
                    <a href="ManageCategories">
                        <i class="bi bi-circle"></i><span>Categories</span>
                    </a>
                </li>
                <li>
                    <a href="AddCategories">
                        <i class="bi bi-circle"></i><span>New Category</span>
                    </a>
                </li>
            </ul>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#manageBorrower-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Manage Borrower</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="manageBorrower-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="ListBorrowed">
                        <i class="bi bi-circle"></i><span>Borrowers</span>
                    </a>
                </li>
                <li>
                    <a href="CreateBorrowed">
                        <i class="bi bi-circle"></i><span>New borrower</span>
                    </a>
                </li>
            </ul>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#manageUser-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Manage User</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="manageUser-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="Users">
                        <i class="bi bi-circle"></i><span>Users</span>
                    </a>
                </li>
            </ul>
        </li>


        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="Profile">
                <i class="bi bi-person"></i>
                <span>Profile</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="Register">
                <i class="bi bi-card-list"></i>
                <span>Register</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="Logout">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Logout</span>
            </a>
        </li>

    </ul>

</aside>

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Dashboard</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="Dashboard">Home</a></li>
                <li class="breadcrumb-item active">Borrowers</li>
            </ol>
        </nav>
    </div>

    <section class="section dashboard">
        <div class="row">

            <div class="col-lg-12">
                <div class="row">

                    <div class="col-12">
                        <div class="card recent-sales overflow-auto">

                            <div class="card-body">
                                <div style="display: flex; align-items: center;">
                                    <h5 class="card-title col-2">Books</h5>
                                    <div class="col-lg-2">
                                        <select id="Option" class="form-select" aria-label="Default select example"
                                                onchange="getSelectedId()">
                                            <option value="1" selected="selected">Chưa trả</option>
                                            <option value="2">Hết hạn</option>
                                            <option value="3">Lịch sử mượn trả</option>

                                        </select>
                                    </div>
                                </div>
                                <table class="table table-borderless datatable">
                                    <thead>
                                    <tr>
                                        <th scope="col">STT</th>
                                        <th scope="col">Tên</th>
                                        <th scope="col">MSSV</th>
                                        <th scope="col">Tên sách mượn</th>
                                        <th scope="col">Ngày mượn</th>
                                        <th scope="col">Hạn cuối</th>
                                        <th scope="col">Xác nhận</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="borrowed" items="${borroweds}" varStatus="STT">
                                        <tr>
                                            <td>${STT.count}</td>
                                            <td>${borrowed.name}</td>
                                            <td>${borrowed.mssv}</td>
                                            <td>${borrowed.book_name}</td>
                                            <td>${borrowed.borrower_date}</td>
                                            <td>${borrowed.deadline_date}</td>
                                            <td><a href="UpdateBorrowed?id=${borrowed.id}"
                                                   class="btn btn-success btn-comfirm" data-bs-toggle="modal"
                                                   data-bs-target="#comfirmModal">Xác nhận</a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <table class="table table-borderless datatable ">
                                    <thead>
                                    <tr>
                                        <th scope="col">STT</th>
                                        <th scope="col">Tên</th>
                                        <th scope="col">MSSV</th>
                                        <th scope="col">Tên sách mượn</th>
                                        <th scope="col">Ngày mượn</th>
                                        <th scope="col">Hạn cuối</th>
                                        <th scope="col">Xác nhận</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="over" items="${overs}" varStatus="STT">
                                        <tr>
                                            <td>${STT.count}</td>
                                            <td>${over.name}</td>
                                            <td>${over.mssv}</td>
                                            <td>${over.book_name}</td>
                                            <td>${over.borrower_date}</td>
                                            <td>${over.deadline_date}</td>
                                            <td><a href="UpdateBorrowed?id=${over.id}"
                                                   class="btn btn-success btn-comfirm" data-bs-toggle="modal"
                                                   data-bs-target="#comfirmModal">Xác nhận</a></td>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <table class="table table-borderless datatable">
                                    <thead>
                                    <tr>
                                        <th scope="col">STT</th>
                                        <th scope="col">Tên</th>
                                        <th scope="col">MSSV</th>
                                        <th scope="col">Tên sách mượn</th>
                                        <th scope="col">Ngày mượn</th>
                                        <th scope="col">Hạn trả</th>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="returned" items="${returneds}" varStatus="STT">
                                        <tr>
                                            <td>${STT.count}</td>
                                            <td>${returned.name}</td>
                                            <td>${returned.mssv}</td>
                                            <td>${returned.book_name}</td>
                                            <td>${returned.borrower_date}</td>
                                            <td>${returned.return_date}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>


                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Right side columns -->

        </div>
    </section>


</main><!-- End #main -->

<!-- Modal -->
<div class="modal fade" id="comfirmModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">Delete Confirmation</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Do you want delete user?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
                <a class="btn btn-primary" id="btn-yes" data-bs-dismiss="handleDelete">YES</a>
            </div>
        </div>
    </div>
</div>

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/chart.js/chart.min.js"></script>
<script src="assets/vendor/echarts/echarts.min.js"></script>
<script src="assets/vendor/quill/quill.min.js"></script>
<script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="assets/vendor/tinymce/tinymce.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>
<script>
    document.querySelectorAll('.fixed-columns')[1].classList.add("hidden")
    document.querySelectorAll('.fixed-columns')[2].classList.add("hidden")

    function getSelectedId() {
        const tables = document.querySelectorAll('.fixed-columns')
        tables.forEach((table, index) => {
            console.log(index, document.querySelector('#Option').selectedIndex)
            if (index == document.querySelector('#Option').selectedIndex) {
                table.classList.remove("hidden")
            } else {
                table.classList.add('hidden')
            }
        })
    }

    $(".btn-comfirm").on("click", function (e) {
        e.preventDefault();
        var link = $(this).attr("href");
        $("#btn-yes").attr("href", link);
    });

</script>
</body>

</html>