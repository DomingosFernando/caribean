<!doctype html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Registrando Quarto</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">


    <asset:stylesheet src="vendors/bootstrap/dist/css/bootstrap.min.css"/>
    <asset:stylesheet src="vendors/font-awesome/css/font-awesome.min.css"/>
    <asset:stylesheet src="vendors/themify-icons/css/themify-icons.css"/>
    <asset:stylesheet src="vendors/flag-icon-css/css/flag-icon.min.css"/>
    <asset:stylesheet src="vendors/selectFX/css/cs-skin-elastic.css"/>

    <asset:stylesheet src="css/style2.css"/>

</head>

<body class="bg-dark">

<div class="sufee-login d-flex align-content-center flex-wrap" style="width: 50%;background-color: white;margin:0 auto">
    <div class="container">
        <div class="login-content">
            <div class="login-logo">
                <a href="index.html">
                    <asset:image class="align-content" src="Logo.png"/>
                </a>
            </div>

            <div class="login-form">

                <g:uploadForm controller="Quarto">
                    <g:hiddenField name="id" value="${quarto.id}" />
                    <div class="form-group">
                        <label>Valor</label>
                        <g:textField name="valor" class="form-control" placeholder="${quarto.valor}"/>
                    </div>

                    <div class="form-group">
                        <label style="color: darkgray">Alimentacao</label>
                        <fieldset style="border: 2px dotted darkgray;">
                            <g:radioGroup name="alimentacao" labels="${hotel.Alimentacao.list().collect {it.comidas+ it.preco}}"
                                          values="${hotel.Alimentacao.list().collect {it.id}}">
                                <label>
                                    <span class="radioSpan">${it.radio}</span>
                                    ${it.label}
                                </label>
                            </g:radioGroup>
                    </div>

                    <div class="form-group">
                        <label style="color: darkgray">Capacidade</label>
                        <fieldset style="border: 2px dotted darkgray;">
                            <g:radioGroup name="capacidade" labels="['1', '2', '3', '4']"
                                          values="[1, 2, 3, 4]">
                                <label>
                                    <span class="radioSpan">${it.radio}</span>
                                    ${it.label}
                                </label>
                            </g:radioGroup>
                    </div>

                    <div class="form-group">
                        <label>Foto</label>
                        <input type="file" name="arquivo" accept=".jpg, .jpeg, .png" data-max-size="120000"
                               class="form-control"/>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> Aceito os termos e políticas
                        </label>
                    </div>
                    <g:actionSubmit value="Atualizar" action="atualizar" class="btn btn-primary btn-flat m-b-30 m-t-30"/>
                    <div class="social-login-content">
                        <div class="social-button">

                        </div>
                    </div>

                </g:uploadForm>
            </div>
        </div>
    </div>
</div>


<asset:javascript src="jquery-3.3.1.js"/>
<asset:javascript src="vendors/popper.js/dist/umd/popper.min.js"/>
<asset:javascript src="vendors/bootstrap/dist/js/bootstrap.min.js"/>
<asset:javascript src="assets/js/main.js"/>


<asset:javascript src="vendors/chart.js/dist/Chart.bundle.min.js"/>
<asset:javascript src="assets/js/dashboard.js"/>
<asset:javascript src="assets/js/widgets.js"/>
<asset:javascript src="vendors/jqvmap/dist/jquery.vmap.min.js"/>
<asset:javascript src="vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"/>
<asset:javascript src="vendors/jqvmap/dist/maps/jquery.vmap.world.js"/>

<asset:javascript src="wow.min.js"/>
<asset:javascript src="venobox.min.js"/>
<asset:javascript src="superfish.min.js"/>
<asset:javascript src="owl.carousel.min.js"/>

<!-- JavaScript Libraries -->
<asset:javascript src="modernizr.min.js"/>
<asset:javascript src="validate.js"/>
<asset:javascript src="easing.min.js"/>
<asset:javascript src="cubeportfolio.js"/>
<asset:javascript src="classie.js"/>
<asset:javascript src="fullpage-menu.js"/>
<asset:javascript src="photostack.js"/>
<asset:javascript src="superslides.js"/>
<script>
    (function ($) {
        "use strict";

        jQuery('#vmap').vectorMap({
            map: 'world_en',
            backgroundColor: null,
            color: '#ffffff',
            hoverOpacity: 0.7,
            selectedColor: '#1de9b6',
            enableZoom: true,
            showTooltip: true,
            values: sample_data,
            scaleColors: ['#1de9b6', '#03a9f5'],
            normalizeFunction: 'polynomial'
        });
    })(jQuery);
</script>

</body>

</html>
