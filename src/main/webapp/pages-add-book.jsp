<%--
  Created by IntelliJ IDEA.
  User: minhquan
  Date: 01/12/2022
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
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
    <link href="assets/img/logodhbk.jpg" rel="icon">
    <link href="assets/img/logodhbk.jpg" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

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
                <i class="bi bi-menu-button-wide"></i><span>Manage borrowed book</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="manageBorrower-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="ListBorrowed">
                        <i class="bi bi-circle"></i><span>Borrowed books</span>
                    </a>
                </li>
                <li>
                    <a href="CreateBorrowed">
                        <i class="bi bi-circle"></i><span>New borrowing</span>
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
        <h1>Add book</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="Dashboard">Home</a></li>
                <li class="breadcrumb-item active">Add book</li>
            </ol>
        </nav>
    </div>

    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0 text-dark"></h1>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
    <section class="content">

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <!-- general form elements -->
                    <div class="card card-primary">
                        <div class="card-header" style="background-color: #0c63e4">
                            <h3 class="card-title" style="color: white">Th??m s??ch v??o th?? vi???n</h3>
                        </div>
                        <div class="row justify-content-center"
                             style="margin-top: 15px; margin-bottom: -15px;">
                            <div style="color: red;"></div>
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form role="form" method="post"
                              action="AddBook"
                              enctype="multipart/form-data">

                            <div class="card-body" >
                                <div class="form-group" style="padding-top: 10px">
                                    <label>Nh???p t??n s??ch</label> <input type="text"
                                                                        class="form-control" id="name" name="name"
                                                                        placeholder="Nh???p t??n s??ch">
                                </div>
                                <div class="form-group" style="padding-top: 10px">
                                    <label>Th??? lo???i</label> <select name="category" id="category"
                                                                    class="form-control" required>
                                    <!-- <option value="">Ch???n 1 th??? lo???i</option> -->
                                    <c:forEach items="${categoryList}" var="category">
                                        <option value="${Integer.toString(category.getId())}">${category.getName()}</option>
                                    </c:forEach>
                                </select>
                                </div>
                                <div class="form-group" style="padding-top: 10px">
                                    <label>S??? l?????ng</label> <input type="number"
                                                                   class="form-control" id="count" name="count" min="1" value="1">
                                </div>
                                <div class="form-group" style="padding-top: 10px">
                                    <label>Nh???p t??n t??c gi???</label> <input type="text"
                                                                        class="form-control" id="author" name="author"
                                                                        placeholder="Nh???p t??n t??c gi???">
                                </div>
                                <div class="form-group" style="padding-top: 20px">
                                    <label>Choose a file</label>
                                    <input type="file" class="form-control" name="AddBook" required/>
<%--                                    <form method="post" action="AddBook" enctype="multipart/form-data">--%>
<%--                                        Choose a file: <input type="file" name="multiPartServlet" />--%>
<%--                                        <input type="submit" value="Upload" />--%>
<%--                                    </form>--%>

<%--                                    <label for="exampleInputFile">Th??m ???nh b??a</label>--%>
<%--                                    <div class="input-group">--%>
<%--                                        <div class="custom-file">--%>
<%--                                            <input type="file"--%>
<%--                                                   accept="image/png, image/jpeg"--%>
<%--                                                   class="custom-file-input"--%>
<%--                                                   id="fileImage"--%>
<%--                                                   name="fileImage"--%>
<%--                                                   required> <label class="custom-file-label"--%>
<%--                                                                    for="fileImage"--%>
<%--                                                                    style="color: #a6b0ba;">Nh???n ????y ????? ch???n file</label>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
                                </div>
                            </div>
                            <div class="card-footer">
                                <button type="submit" class="btn btn-primary ">L??u</button>
                                <input type="button" value="Tr??? l???i" class="btn btn-primary"
                                       onclick="location.href='${pageContext.request.contextPath}/ManageBook'">
                            </div>
                        </form>
                    </div>


                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
    </section>


</main><!-- End #main -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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

</body>

</html>
