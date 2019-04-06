/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#autocomplete").autocomplete({
        //lookup: countries,
        serviceUrl: 'buscador'
                ////set width
                //callback just to show it's working
//                    onSelect: function (suggestion) {
//                        //$('#tipo').val('Tu seleccionaste: ' + suggestion.data + ', ' + suggestion.value+ ', ' + suggestion.tipo);
//                        $('#tipo').val(suggestion.tipo);
//                    },
//                    showNoSuggestionNotice: false,
//                    noSuggestionNotice: '',
    });
});