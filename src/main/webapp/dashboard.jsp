<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Dashboard - Library</title>
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
    <h1>Dashboard</h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="Dashboard">Home</a></li>
        <li class="breadcrumb-item active">Dashboard</li>
      </ol>
    </nav>
  </div>

  <section class="section dashboard">
    <div class="row">

      <div class="col-lg-8">
        <div class="row">

          <div class="col-xxl-6 col-md-6">
            <div class="card info-card sales-card">

              <div class="card-body">
                <h5 class="card-title">Books</h5>

                <div class="d-flex align-items-center">
                  <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                    <img src="./assets/img/book-stack.png" style="width: 32px; height: 32px" alt="">
                  </div>
                  <div class="ps-3">
                    <h6>${total_books}</h6>
                  </div>
                </div>
              </div>

            </div>
          </div>

          <div class="col-xxl-6 col-md-6">
            <div class="card info-card revenue-card">

              <div class="filter">
                <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                  <li class="dropdown-header text-start">
                    <h6>Category</h6>
                  </li>

                  <c:forEach var="category" items="${categories}">
                      <li><li><p class="dropdown-item" >${category.name}</p></li></li>
                  </c:forEach>

                </ul>
              </div>

              <div class="card-body">
                <h5 class="card-title">Categories</h5>

                <div class="d-flex align-items-center">
                  <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                    <img src="./assets/img/category.png" style="width: 32px; height: 32px" alt="">
                  </div>
                  <div class="ps-3">
                    <h6>${total_categories}</h6>
                  </div>
                </div>
              </div>

            </div>
          </div>

          <div class="col-12">
            <div class="card recent-sales overflow-auto">

              <div class="card-body">
                <h5 class="card-title">Books</h5>

                <table class="table table-borderless datatable table-striped table-hover">
                  <thead>
                  <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Preview</th>
                    <th scope="col">Author</th>
                    <th scope="col">Category</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="book" items="${books}">
                      <tr>
                          <td>${book.name}</td>
                          <td><img src="Resources/img/products/${book.getImage()}" width="75px" height="75px"></td>
                          <td>${book.author}</td>
                          <td>${book.category_name}</td>
                      </tr>
                  </c:forEach>
                  </tbody>
                </table>

              </div>
            </div>
          </div>

          <div class="col-12">
            <div class="card top-selling overflow-auto">

              <div class="card-body pb-0">
                <h5 class="card-title">Top Borrower</h5>

                <table class="table table-borderless">
                  <thead>
                  <tr>
                    <th scope="col">Preview</th>
                    <th scope="col">Name</th>
                    <th scope="col">Author</th>
                    <th scope="col">Category</th>
                    <th scope="col">Times</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="topBook" items="${topBooks}">
                    <tr>
                      <td><img src="Resources/img/products/${topBook.book.getImage()}" width="75px" height="75px"></td>
                      <td><p class="text-primary fw-bold">${topBook.book.name}</p></td>
                      <td>${topBook.book.author}</td>
                      <td class="fw-bold">${topBook.book.category_name}</td>
                      <td>${topBook.times}</td>
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
      <div class="col-lg-4">

        <div class="card">

          <div class="card-body pb-0">
            <h5 class="card-title">Categories</h5>

            <div id="trafficChart" style="min-height: 400px;" class="echart"></div>

            <script>
              document.addEventListener("DOMContentLoaded", () => {

                echarts.init(document.querySelector("#trafficChart")).setOption({
                  tooltip: {
                    trigger: 'item'
                  },
                  legend: {
                    top: 0,
                    left: 'center'
                  },
                  series: [{
                    name: 'Categories Form',
                    type: 'pie',
                    radius: ['40%', '70%'],
                    avoidLabelOverlap: false,
                    label: {
                      show: false,
                      position: 'center'
                    },
                    emphasis: {
                      label: {
                        show: true,
                        fontSize: '18',
                        fontWeight: 'bold'
                      }
                    },
                    labelLine: {
                      show: false
                    },
                    data: [
                        <c:forEach var="topCategory" items="${topCategories}" varStatus="status">
                        {
                          name: '${topCategory.name}',
                          value: '${topCategory.value}'
                        }
                        <c:if test="${!status.last}">
                        ,
                        </c:if>
                        </c:forEach>
                    ]
                  }]
                });
              });
            </script>

          </div>
        </div>

      </div><!-- End Right side columns -->

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