<%--
  Created by IntelliJ IDEA.
  User: minhquan
  Date: 01/12/2022
  Time: 15:32
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
    <h1>Manage Categories</h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="Dashboard">Home</a></li>
        <li class="breadcrumb-item active">Manage categories</li>
      </ol>
    </nav>
  </div>

  <div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
      <div class="row justify-content-center">
        <div style="margin-top: 20px; color: red;"></div>
      </div>
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-6">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Danh s??ch th??? lo???i s??ch</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">

                <table class="table table-bordered">
                  <thead>
                  <tr>
                    <th style="width: 10px">STT</th>
                    <th>T??n th??? lo???i</th>
                    <th>Ch???nh s???a</th>
                    <th>X??a</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${categoryList}" var="category"
                             varStatus="loop">
                    <tr>
                      <td>${loop.index+1}</td>
                      <td>${category.getName()}</td>
                      <td><a
                              href="${pageContext.request.contextPath}/EditCategories?id=${category.getId()}"
                              class="btn btn-sm btn-info">Ch???nh s???a</a></td>
                      <td>
                        <button type="button" class="btn btn-primary btn-danger" onclick="handleDelete(${category.getId()})"
                                data-bs-toggle="modal" data-bs-target="#exampleModal"
                                style="padding-bottom: 5px; padding-top: 3px; font-size: 14px">X??a
                        </button>
                      </td>
                    </tr>

<%--                    <div class="modal fade"--%>
<%--                         id="staticBackdrop-${Integer.toString(category.getId())}"--%>
<%--                         data-backdrop="static" data-keyboard="false" tabindex="-1"--%>
<%--                         aria-labelledby="staticBackdropLabel" aria-hidden="true">--%>
<%--                      <div class="modal-dialog">--%>
<%--                        <div class="modal-content">--%>
<%--                          <div class="modal-header">--%>
<%--                            <h5 class="modal-title" id="staticBackdropLabel1">Ch??--%>
<%--                              ??</h5>--%>
<%--                            <button type="button" class="close" data-dismiss="modal"--%>
<%--                                    aria-label="Close">--%>
<%--                              <span aria-hidden="true">&times;</span>--%>
<%--                            </button>--%>
<%--                          </div>--%>
<%--                          <div class="modal-body">--%>
<%--														<span class="text-danger"> B???n c?? mu???n ch???c x??a th???--%>
<%--															lo???i '${category.getName()}'</span>--%>
<%--                          </div>--%>
<%--                          <div class="modal-footer">--%>
<%--                            <button type="button"--%>
<%--                                    class="btn btn-warning  btn-secondary"--%>
<%--                                    data-dismiss="modal">H???y</button>--%>
<%--                            <form--%>
<%--                                    action="${pageContext.request.contextPath}/DeleteCategories?id=${category.getId()}"--%>
<%--                                    method="POST">--%>
<%--                              <button type="submit" class="btn btn-danger">X??a</button>--%>
<%--                            </form>--%>

<%--                          </div>--%>
<%--                        </div>--%>
<%--                      </div>--%>
<%--                    </div>--%>

                  </c:forEach>
                  </tbody>
                </table>
                <div class="card-header" style="margin-left: -20px;">
                  <input type="button" value="Th??m th??? lo???i"
                         class="btn btn-primary"
                         onclick="location.href='${pageContext.request.contextPath}/AddCategories'">
                </div>
              </div>

            </div>
            <!-- /.card -->
          </div>
        </div>
        <!-- /.container-fluid -->
      </div>
    </section>
  </div>

  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <span class="text-danger"><p class="detail">B???n c?? mu???n ch???c mu???n x??a th??? lo???i n??y kh??ng ? </p></span>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">????ng</button>
          <a href="" id="deleteLink"><button type="button" class="btn btn-primary">Xo??</button></a>
        </div>
      </div>
    </div>
  </div>

</main>
<!-- End #main -->

<script>
  function handleDelete(id) {
    document.getElementById("deleteLink").setAttribute("href", "${pageContext.request.contextPath}/DeleteCategories?id=" + id.toString());
  }
</script>

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