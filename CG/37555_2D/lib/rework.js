

function enter(c, dx, dy, sx, sy) {
	c.save();
	c.translate(dx,dy);
	c.scale(sx,sy);
}


function leave(c, fs, ss) {
	c.restore();
	c.fillStyle = fs;
	c.strokeStyle = ss;   
	c.fill();
	c.stroke();    
}


function draw_background(c){
	c.fillStyle = 'rgb(255, 10, 15)';
	c.fillRect( 0, 0, 244, 400);
}

function text(c, font, text, fillStyle, strokeStyle){
	c.font = font;
	c.fillStyle = fillStyle;
	c.strokeStyle = strokeStyle;
	c.strokeText(text, 0, 0);
	c.fillText(text, 0, 0);
}

function logo_background(c){

	c.beginPath();
		c.moveTo( 0.0517, 0.9346);
		c.bezierCurveTo( 0.052, 0.8894, 0.1217, 0.902, 0.115, 0.9344);
		c.bezierCurveTo( 0.1193, 0.9698, 0.056, 0.9803, 0.0517, 0.9346);
	c.closePath();
}

function logo_outline(c){

	c.beginPath();
		c.moveTo( 0.0486, 0.933);
		c.bezierCurveTo( 0.049,  0.9812, 0.1217, 0.9737, 0.1186, 0.9334);
		c.bezierCurveTo( 0.1145, 0.8918, 0.0517, 0.896, 0.0486, 0.933);
	c.closePath();

}

function logo_penguin_outline(c){

	c.beginPath();
	c.moveTo( 0.0769, 0.922);
		c.bezierCurveTo( 0.0524, 0.9446, 0.0628, 0.9519, 0.0667, 0.9332);
		c.bezierCurveTo( 0.0715, 0.9365, 0.065, 0.949, 0.0726, 0.9534);
		c.bezierCurveTo( 0.0703, 0.9549, 0.0594, 0.9594, 0.0771, 0.9568);
		c.bezierCurveTo( 0.0798, 0.9513, 0.0883, 0.9526, 0.093, 0.953);
		c.bezierCurveTo( 0.0883, 0.957, 0.0853, 0.9581, 0.1008, 0.9572);
		c.bezierCurveTo( 0.0881, 0.9525, 0.1079, 0.9523, 0.0966, 0.9341);
		c.bezierCurveTo( 0.1101, 0.947, 0.1126, 0.944, 0.0953, 0.9229);
		c.bezierCurveTo( 0.0862, 0.9203, 0.1009, 0.907, 0.0778, 0.9115);
		c.bezierCurveTo( 0.0684, 0.9113, 0.0637, 0.9113, 0.0763, 0.9147);
	c.closePath();
}


function logo_pinguin_tummy_white(c){

	c.beginPath();
		c.moveTo( 0.0738, 0.9291);
		c.bezierCurveTo( 0.0756, 0.9206, 0.0917, 0.9218, 0.0932, 0.9248);
		c.bezierCurveTo( 0.0983, 0.9281, 0.091, 0.9364, 0.0987, 0.9438);
		c.bezierCurveTo( 0.1017, 0.9545, 0.0707, 0.9531, 0.0714, 0.9488);
		c.bezierCurveTo( 0.0717, 0.9468, 0.0666, 0.938, 0.0733, 0.931);
	c.closePath();

}


function logo_pinguin_head_white(c){

	c.beginPath();
		c.moveTo( 0.0803, 0.9206);
		c.bezierCurveTo( 0.0784, 0.9162, 0.09, 0.9198, 0.0872, 0.9157);
		c.bezierCurveTo( 0.0738, 0.9182, 0.0843, 0.9088, 0.0872, 0.9122);
		c.bezierCurveTo( 0.0901, 0.9145, 0.0912, 0.9214, 0.0837, 0.9202);
	c.closePath();
}

function pig(c){

	c.beginPath()
		c.moveTo(1, 0.482);	
		c.bezierCurveTo( 0.833, 0.506, 0.536, 0.488, 0.43, 0.509);
		c.bezierCurveTo( 0.338, 0.541, 0.345, 0.478, 0.284, 0.484);
		c.bezierCurveTo( 0.3147, 0.542, 0.237, 0.4704, 0.19, 0.502);
		c.lineTo(0.252, 0.5896);
		c.bezierCurveTo( 0.2515, 0.601, 0.125, 0.6556, 0.1144, 0.638);
		c.bezierCurveTo( 0.101, 0.631, 0.083, 0.6234, 0.09, 0.69);
		c.bezierCurveTo( 0.142, 0.7305, 0.1577, 0.688, 0.2264, 0.729);
		c.bezierCurveTo( 0.267, 0.745, 0.33, 0.769, 0.401, 0.757);
		c.bezierCurveTo( 0.4106, 0.7564, 0.4925, 0.783, 0.5567, 0.782);
		c.bezierCurveTo( 0.5367, 0.796, 0.6265, 0.8355, 0.52, 0.9126);
		c.bezierCurveTo( 0.5097, 0.9366, 0.5525, 0.9246, 0.58, 0.9276);
		c.bezierCurveTo( 0.5863, 0.9275, 0.5958, 0.9125, 0.594, 0.9066);
		c.bezierCurveTo( 0.643, 0.9122, 0.6069, 0.8626, 0.64633, 0.8416);
		c.bezierCurveTo( 0.6943, 0.8876, 0.6287, 0.9352, 0.6215, 0.935);
		c.bezierCurveTo( 0.6077, 0.9511, 0.668, 0.9436, 0.6822, 0.9454);
		c.bezierCurveTo( 0.6977, 0.9454, 0.6998, 0.9340, 0.6958, 0.923);
		c.bezierCurveTo( 0.7033, 0.9197, 0.725, 0.9465, 0.7232, 0.9195);
		c.bezierCurveTo( 0.6955, 0.725, 0.797, 0.791, 0.8497, 0.7795);
		c.bezierCurveTo( 0.863, 0.7806, 0.9175, 0.7705, 1, 0.7970);
	c.closePath();

}	

function logo(c){

	enter(c, 0, 0, 244, 400);
	logo_outline(c);
	leave(c, "black", "black");

	enter(c, 0, 0, 244, 400);
	logo_background(c);
	leave(c, "rgb(248, 84, 13)", "black");

	enter(c, 0, 0, 244, 400);
	logo_penguin_outline(c);
	leave(c, "black", "black");

	enter(c, 0, 0, 244, 400);
	logo_pinguin_tummy_white(c);
	leave(c, "white", "white");

	enter(c, 0, 0, 244, 400);
	logo_pinguin_head_white(c);
	leave(c, "white", "white");

}


function capa(c, font, font2, font3){

	draw_background(c);

	logo(c);

	enter(c, 0, 0, 244, 400);
	pig(c);
	leave(c, "rgb(252, 176, 142)", "rgb(252, 176, 142)");
	
	enter(c, 11.6876, 63.68, 1.1, 1);
	text(c, "50px " + font, "ANIMAL", "black", "black");
	leave(c, "", "");//os valores de Style estão nulls pois não estavam a funcionar e decidi alterar

	enter(c, 14.1276, 118.72, 1.05, 1);
	text(c, "50px " + font, "FARM", "black", "black");
	leave(c, "", "");

	enter(c, 13.27, 169.2, 2 , 2.2);
	text(c, "23px " + font2, "GEORGE ORWELL", "rgb(245,245,220)", "rgb(245,245,220)");
	leave(c, "", "");

	enter(c, 62.366, 223.88, 1, 1);
	text(c, "23px " + font3, "All ANIMALS", "rgb(256,242,216)", "rgb(256,242,216)");
	leave(c, "", "");

	enter(c, 63.684, 248.16, 1, 1);
	text(c, "23px " + font3, "ARE EQUAL. BUT", "rgb(256,242,216)", "rgb(256,242,216)");
	leave(c, "", "");

	enter(c, 35.868, 270.92, 1, 1);
	text(c, "23px " + font3, "SOME ANIMALS ARE", "rgb(256,242,216)", "rgb(256,242,216)");
	leave(c, "", "");

	enter(c, 63.318, 295.24, 1, 1);
	text(c, "23px " + font3, "MORE EQUAL THAN" ,"rgb(256,242,216)", "rgb(256,242,216)");
	leave(c, "", "");

	enter(c, 144.544, 313.6, 1, 1);
	text(c, "23px " + font3, "OTHERS", "rgb(256,242,216)", "rgb(256,242,216)");
	leave(c, "", "");

}	
	
function main(){
	var animal_farm_ctx = document.getElementById('animal_farm').getContext('2d');

	var FontName1 = "FranklySpokenTwo";
	var FontName2 = "libelsuit";
	var FontName3= "ComicSans";

	capa(animal_farm_ctx, FontName1, FontName2, FontName3);
}