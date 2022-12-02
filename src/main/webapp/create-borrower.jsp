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
  <style>
    .hidden{
      display: none;
    }
    .mg-left{
      margin-left: 15px;
    }

  </style>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/js/standalone/selectize.min.js" integrity="sha256-+C0A5Ilqmu4QcSPxrlGpaZxJ04VjsRjKu+G82kl5UJk=" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/css/selectize.bootstrap3.min.css" integrity="sha256-ze/OEYGcFbPRmvCnrSeKbRTtjG4vGLHXgOqsyLFTRjg=" crossorigin="anonymous" />

</head>

<body>

<header id="header" class="header fixed-top d-flex align-items-center">

  <div class="d-flex align-items-center justify-content-between">
    <a href="index.jsp" class="logo d-flex align-items-center">
      <img src="assets/img/Logodhbk.jpg" alt="">
      <span class="d-none d-lg-block">Libray</span>
    </a>
    <i class="bi bi-list toggle-sidebar-btn"></i>
  </div>

  <nav class="header-nav ms-auto">
    <ul class="d-flex align-items-center">

      <li class="nav-item dropdown pe-3">

        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
          <img src="assets/img/profile.png" alt="Profile" class="rounded-circle">
          <span class="d-none d-md-block dropdown-toggle ps-2">NAME</span>
        </a>

        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
          <li class="dropdown-header">
            <h6>NAME</h6>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li>
            <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
              <i class="bi bi-person"></i>
              <span>My Profile</span>
            </a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li>
            <a class="dropdown-item d-flex align-items-center" href="#">
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
      <a class="nav-link " href="index.html">
        <i class="bi bi-grid"></i>
        <span>Dashboard</span>
      </a>
    </li>

    <li class="nav-item">
      <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
        <i class="bi bi-menu-button-wide"></i><span>Manage Book</span><i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
        <li>
          <a href="components-alerts.html">
            <i class="bi bi-circle"></i><span>Books</span>
          </a>
        </li>
        <li>
          <a href="components-accordion.html">
            <i class="bi bi-circle"></i><span>New Book</span>
          </a>
        </li>
        <li>
          <a href="components-badges.html">
            <i class="bi bi-circle"></i><span>Categories</span>
          </a>
        </li>
        <li>
          <a href="components-breadcrumbs.html">
            <i class="bi bi-circle"></i><span>New Category</span>
          </a>
        </li>
      </ul>
    </li>

    <li class="nav-item">
      <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
        <i class="bi bi-menu-button-wide"></i><span>Manage Borrower</span><i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">

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

    <li class="nav-heading">Pages</li>

    <li class="nav-item">
      <a class="nav-link collapsed" href="users-profile.html">
        <i class="bi bi-person"></i>
        <span>Profile</span>
      </a>
    </li>

    <li class="nav-item">
      <a class="nav-link collapsed" href="pages-contact.html">
        <i class="bi bi-envelope"></i>
        <span>Contact</span>
      </a>
    </li>

    <li class="nav-item">
      <a class="nav-link collapsed" href="pages-register.jsp">
        <i class="bi bi-card-list"></i>
        <span>Register</span>
      </a>
    </li>

    <li class="nav-item">
      <a class="nav-link collapsed" href="pages-login.jsp">
        <i class="bi bi-box-arrow-in-right"></i>
        <span>Logout</span>
      </a>
    </li>

  </ul>

</aside>

<main id="main" class="main">

  <div class="pagetitle">
    <h1>Thêm người mượn sách</h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
        <li class="breadcrumb-item active">Thêm người mượn sách</li>
      </ol>
    </nav>
  </div>

  <section >
    <form class="card-body col-md-6 m-auto" action="SaveBorrowed" method="post" >
      <div class="form-row col-md-12 m-auto">
        <div class="form-group col-md-12 m-2">
          <label for="inputName" class="mg-left">Họ và tên</label>
          <input type="text" class="form-control m-2" name ="nameBorrowed" id="inputName" placeholder="Nhập họ và tên" required>
        </div>

        <div class="form-group col-md-12 m-2">
          <label for="inputMSSV" class="mg-left">MSSV</label>
          <input type="text" class="form-control m-2" id="inputMSSV"  name= "MSSV" placeholder="Nhập mã số sinh viên"
                 onkeypress='return event.charCode >= 48 && event.charCode <= 57' required>
        </div>

        <div class="form-group col-md-12 m-2">
          <label for="inputNameBook" class="mg-left">Tên sách</label>
          <select id="inputNameBook" class="form-control m-2" name= "idBook" onchange="changeSelected()">
            <c:forEach var="Book" items="${Books}">
                <option value=${Book.id}>${Book.name}</option>
            </c:forEach>
          </select>
        </div>
        <div class="form-group col-md-12 m-2">
          <label for="inputDeadline" class="mg-left">Hạn trả</label>
          <select id="inputDeadline" class="form-control m-2" name="duration">
            <option selected>1 week</option>
            <option>2 week</option>
            <option>1 month</option>
            <option>3 months</option>
          </select>
        </div>
      </div>
      <div class ="d-flex justify-content-center gap-3">
        <input type="reset" class="btn btn-primary" value="Cancel"/>
        <button type="submit" class="btn btn-primary">Create</button>
      </div>
    </form>
  </section>



</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">

  <div class="copyright">
    &copy; Copyright <strong><span>HKQ</span></strong>
  </div>
  <!-- Modal -->

</footer><!-- End Footer -->

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
<script>
  $(document).ready(function () {
    $('select').selectize({
      sortField: 'text'
    });
  });
</script>
</body>

</html>