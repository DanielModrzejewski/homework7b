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
<form ACTION="aplikacja" METHOD="GET" class="form-signin">
    <img class="mb-4" src="fibonacci.png" alt="" >
    <h1 class="h3 mb-3 font-weight-normal">${fn} : ${fibAct}</h1>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Back</button>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Fibonacci</th>
        </tr>
        </thead>
        <tbody>
        <#assign number=0>
        <#list fibList as fib>
            <tr>
                <th scope="row">${number}</th>
                <td>${fib}</td>
                <#assign number+=1>
            </tr>
        </#list>
        </tbody>
    </table>
</form>
</body>
</html>