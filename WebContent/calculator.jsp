<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean type="tscislo.CalculatorBean" id="calculatorBean"
	scope="session" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Calculator</title>
<link rel="stylesheet" href="./styles.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
</head>


<body>

	<form class="container" method="post">
		<div id="calc" class="text-center">
			<div id="display">
				<div id="result">
					<p><%=calculatorBean.getCurrentOnDisplay()%></p>
				</div>
			</div>
			<div id="keyboard">
				<div class="row">
					<button name="operation" class="btn btn-info" value="7"
						type="submit">7</button>
					<button name="operation" class="btn btn-info" value="8"
						type="submit">8</button>
					<button name="operation" class="btn btn-info" value="9"
						type="submit">9</button>
					<button name="operation" class="btn btn-warning" value="%"
						type="submit">%</button>
					<button name="operation" class="btn btn-danger" value="ce"
						type="submit">CE</button>
				</div>
				<div class="row">
					<button name="operation" class="btn btn-info" value="4"
						type="submit">4</button>
					<button name="operation" class="btn btn-info" value="5"
						type="submit">5</button>
					<button name="operation" class="btn btn-info" value="6"
						type="submit">6</button>
					<button name="operation" class="btn btn-warning" value="/"
						type="submit">/</button>
					<button name="operation" class="btn btn-warning" value="*"
						type="submit">*</button>
				</div>
				<div class="row">
					<button name="operation" class="btn btn-info" value="1"
						type="submit">1</button>
					<button name="operation" class="btn btn-info" value="2"
						type="submit">2</button>
					<button name="operation" class="btn btn-info" value="3"
						type="submit">3</button>
					<button name="operation" class="btn btn-warning" value="+"
						type="submit">+</button>
					<button name="operation" class="btn btn-success btn-result"
						value="=" type="submit">=</button>

				</div>
				<div class="row last-row">
					<button name="operation" class="btn btn-info" value="0"
						type="submit">0</button>
					<button name="operation" class="btn btn-warning" value="sqrt"
						type="submit">sqrt</button>
					<button name="operation" class="btn btn-warning" value="."
						type="submit">.</button>
					<button name="operation" class="btn btn-warning" value="-"
						type="submit">-</button>
				</div>
			</div>
		</div>
	</form>

</body>

</html>