<!DOCTYPE <!DOCTYPE html>
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

	<form class="container">
		<div id="calc" class="text-center">
			<div id="display">
				<div id="result">
					<p>0</p>
				</div>
			</div>
			<div id="keyboard">
				<div class="row">
					<button class="btn btn-info" value="7"  type="submit">7</button>
					<button class="btn btn-info" value="8"  type="submit">8</button>
					<button class="btn btn-info" value="9"  type="submit">9</button>
					<button class="btn btn-warning" value="ac"  type="submit">%</button>
					<button class="btn btn-danger" value="ce"  type="submit">CE</button>
				</div>
				<div class="row">
					<button class="btn btn-info" value="4"  type="submit">4</button>
					<button class="btn btn-info" value="5"  type="submit">5</button>
					<button class="btn btn-info" value="6"  type="submit">6</button>
					<button class="btn btn-warning" value="/"  type="submit">/</button>
					<button class="btn btn-warning" value="*"  type="submit">*</button>
				</div>
				<div class="row">
					<button class="btn btn-info" value="1"  type="submit">1</button>
					<button class="btn btn-info" value="2"  type="submit">2</button>
					<button class="btn btn-info" value="3"  type="submit">3</button>
					<button class="btn btn-warning" value="+"  type="submit">+</button>
					<button class="btn btn-success btn-result" value="="  type="submit">=</button>

				</div>
				<div class="row last-row">
					<button class="btn btn-info" value="0"  type="submit">0</button>
					<button class="btn btn-warning" value=""  type="submit">sqrt</button>
					<button class="btn btn-warning" value="."  type="submit">.</button>
					<button class="btn btn-warning" value="-"  type="submit">-</button>
				</div>
			</div>
		</div>
	</form>

</body>

</html>