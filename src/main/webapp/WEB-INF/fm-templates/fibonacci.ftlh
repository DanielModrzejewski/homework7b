<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
</head>

<body class="text-center">
<form class="form-signin">
    <img class="mb-4" src="fibonacci.png" alt="" >
    <h1 class="h3 mb-3 font-weight-normal">Sing in number to count fibonacci</h1>
    <label for="inputNumber" class="sr-only"></label>
    <input type="number" id="inputNumber" class="form-control" pattern="^[0-9]" title='Only Number' min="0" step="1">
    <button class="btn btn-lg btn-primary btn-block" type="submit">Count fibonacci</button>
</form>
</body>
</html>