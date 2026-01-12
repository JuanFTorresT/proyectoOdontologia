<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Register</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Crear nuevo paciente</h1>
                            </div>
                            <form action="${pageContext.request.contextPath}/ValidarRegistro" method="POST" name="registroForm" class="user">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label for="nombrePaciente">Nombre</label>
                                        <input type="text" class="form-control" id="nombrePaciente" name="nombrePaciente" placeholder="Ej. Juan Felipe">
                                    </div>
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label for="apellidoPaciente">Apellido</label>
                                        <input type="text" class="form-control" id="apellidoPaciente" name="apellidoPaciente" placeholder="Ej. Torres Trujillo">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label for="indentificacionPaciente">Identificacion</label>
                                        <input type="text" class="form-control" id="identificacionPaciente" name="identificacionPaciente" placeholder="Ej. 1000111222">
                                    </div>
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label for="fechaNacimientoPaciente">Fecha de nacimiento</label>
                                        <input type="date" class="form-control " id="fechaNacimientoPaciente" name="fechaNacimientoPaciente">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label for="direccionPaciente">Direccion</label>
                                        <input type="text" class="form-control" id="direccionPaciente" name="direccionPaciente" placeholder="Ej. Carrera 10 # 10-10">
                                    </div>
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label for="celularPaciente">Celular</label>
                                        <input type="number" class="form-control" id="celularPaciente" name="celularPaciente" placeholder="Ej. 310 300 25 25">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 d-flex ">
                      					 <div class="form-check">
										   <input class="form-check-input" type="checkbox">
										   <label class="form-check-label">Tiene seguro</label>
										</div>
					
                                    </div>
									<div class="col-sm-6 mb-3 mb-sm-0">
									    <select class="form-control">
									        <option selected>RH del paciente</option>
									        <option value="A+">O+</option>
									        <option value="A+">O-</option>
									        <option value="A+">A+</option>
									        <option value="A-">A-</option>
									        <option value="AB">B+</option>
									        <option value="AB">B-</option>
									        <option value="AB">AB+</option>
									        <option value="AB">AB-</option>
									    </select>
									</div>
                                </div>
                                <!-- DATOS DEL ACUDIENTE -->
                                <div id="datosAcudiente" style="display:none;">
                                	<div class="text-center">
		                                <h1 class="h4 text-gray-900 mb-4">Datos del acudiente</h1>
		                            </div>
                                	
                                	<div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label for="nombreAcudiente">Nombre</label>
                                        <input type="text" class="form-control" id="nombreAcudiente" name="nombreAcudiente" placeholder="Ej. Juan Felipe">
                                    </div>
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label for="apellidoAcudiente">Apellido</label>
                                        <input type="text" class="form-control" id="apellidoAcudiente" name="apellidoAcudiente" placeholder="Ej. Torres Trujillo">
                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-6 mb-3 mb-sm-0">
	                                    	<label for="indentificacionAcudiente">Identificacion</label>
	                                        <input type="text" class="form-control" id="identificacionAcudiente" name="identificacionAcudiente" placeholder="Ej. 1000111222">
	                                    </div>
	                                    <div class="col-sm-6 mb-3 mb-sm-0">
	                                    	<label for="fechaNacimientoAcudiente">Fecha de nacimiento</label>
	                                        <input type="date" class="form-control " id="fechaNacimientoAcudiente" name="fechaNacimientoAcudiente">
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-6 mb-3 mb-sm-0">
	                                    	<label for="direccionAcudiente">Direccion</label>
	                                        <input type="text" class="form-control" id="direccionAcudiente" name="direccionAcudiente" placeholder="Ej. Carrera 10 # 10-10">
	                                    </div>
	                                    <div class="col-sm-6 mb-3 mb-sm-0">
	                                    	<label for="celularAcudiente">Celular</label>
	                                        <input type="number" class="form-control" id="celularAcudiente" name="celularAcudiente" placeholder="Ej. 310 300 25 25">
	                                    </div>
	                                </div>

                                </div>
                                
                                <input type="submit" value="Crear Paciente"  class="btn btn-primary btn-user btn-block"/>
                                <hr>
                                <a href="index.html" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Register with Google
                                </a>
                                <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.html">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
    
    <!-- Logica mostrar formulario acudiente -->
    <script type="text/javascript" src="js/creacionAcudiente.js"></script>

</body>

</html>