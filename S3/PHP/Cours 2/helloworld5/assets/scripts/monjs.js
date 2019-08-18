jQuery(document).ready(function() {
   jQuery("#monFormulaireContact").validate({
      rules: {
         "contact":{
            "required": true,
			"regex": /([a-zA-Z /-])/,
            "minlength": 5,
            "maxlength": 50
         },
          "email":{
            "required": true,
            "email": true,
			"regex": /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/,
            "minlength": 10,
            "maxlength": 50
         },
          "tel":{
            "required": true,
 			"regex": /([0-9 /-])/,
            "minlength": 10,
            "maxlength": 15
         },
         "message": {
            "required": true,
			"regex": /^[^/\\()<>~!@#$%^&*]*$/,
            "minlength": 10,
            "maxlength": 3000
         },
		}
	  })
	});

 jQuery(document).ready(function() {
   jQuery("#monFormulaireLogin").validate({
	 rules: {
		 "identifiant":{
			"required": true,
			"regex": /[0-9A-Za-z!@#$%]{4,50}/,
			"minlength": 4,
			"maxlength": 50
			},
		  "password":{
			"required": true,
			"minlength": 6,
			"maxlength": 50,
			"regex": /[0-9A-Za-z!@#$%]{6,50}$/
			},
	},
  })
 });
	
jQuery(document).ready(function() {
   jQuery("#monFormulaire").validate({
      rules: {
         "url":{
            "required": true,
            "minlength": 2,
            "maxlength": 30
         },
          "titre":{
            "required": true,
            "minlength": 2,
            "maxlength": 50
         },
         "description": {
            "maxlength": 3000
         },
         "abstract": {
            "maxlength": 3000
         },
         "keywords": {
            "maxlength": 50
         }
		}
  })
});

jQuery.extend(jQuery.validator.messages, {
    required: "Champ obligatoire",
    remote: "votre message",
    email: "Votre adresse mail est incorrecte ou manquante",
    url: "votre message",
    date: "votre message",
    dateISO: "votre message",
    number: "Uniquement des nombres ou espace",
    digits: "Uniquement des nombres ou espace",
    creditcard: "votre message",
    equalTo: "votre message",
    accept: "votre message",
    maxlength: jQuery.validator.format("Maximum : {0} caract&egrave;res."),
    minlength: jQuery.validator.format("Minimum : {0} caract&egrave;res."),
    rangelength: jQuery.validator.format("votre message  entre {0} et {1} caractéres."),
    range: jQuery.validator.format("votre message  entre {0} et {1}."),
    max: jQuery.validator.format("votre message  inférieur ou égal à {0}."),
    min: jQuery.validator.format("votre message  supérieur ou égal à {0}.")
  });
  
jQuery.validator.addMethod(
  "regex",
   function(value, element, regexp) {
       if (regexp.constructor != RegExp)
          regexp = new RegExp(regexp);
       else if (regexp.global)
          regexp.lastIndex = 0;
          return this.optional(element) || regexp.test(value);
   },"Format incorrect ou caract&egrave;re interdit"
);

