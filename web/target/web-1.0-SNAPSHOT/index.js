jQuery.extend(
    jQuery.jgrid.edit, {
        ajaxEditOptions: { contentType: "application/json" },
        recreateForm: false,
        serializeEditData: function(postData) {
            return JSON.stringify(postData);
        },

        afterSubmit: function (response, postdata) {
            $(this).jqGrid('setGridParam', { datatype: 'json' }).trigger('reloadGrid', {page: 1});
            return [true]; // no error
        },
        closeAfterEdit: true,
        closeAfterAdd: true
    }
);
jQuery.extend(
    jQuery.jgrid.del, {
        ajaxDelOptions: { contentType: "application/json" },
        recreateForm: true,
        serializeDelData: function(postData) {
            return JSON.stringify(postData);
        },
        afterSubmit: function (response, postdata) {
            return [true, "", 0];
        }
    }
);
$(document).ready(function () {
    $('#menu_list li').hover(function () {
        clearTimeout($.data(this,'timer'));
        $('ul',this).stop(true,true).slideDown(200);
    }, function () {
        $.data(this,'timer', setTimeout($.proxy(function() {
            $('ul',this).stop(true,true).slideUp(200);
        }, this), 100));
    });
    $("#jqGrid").jqGrid({
            url: 'http://localhost:8080/web/list/aircrafts',
            mtype: "GET",
            datatype: "json",
            colNames: ['Код', 'Модель', 'Макс. длина полета'],
            colModel: [
                {   name: 'aircraft_code',
                    index: 'aircraft_code',
                    key: true,
                    width: 220,
                    height: 500,
                    align: "center",
                    editable : true
                },
                {   name: 'model',
                    index: 'model',
                    width: 575,
                    align: "center",
                    height: 500,
                    editable : true
                },
                {   name: 'range',
                    index: 'range',
                    width: 400,
                    align: "center",
                    height: 500,
                    editable : true
                }
            ],
            rownumbers: true,
            gridview: true,
            loadonce: true,
            rowNum: 5,
            pager: "#pag",
            rowList: [5, 10, 15],
            viewrecords: true,
        jsonReader : {
            repeatitems : false
        },
        editurl : "http://localhost:8080/web/list/controller",
            datatype : 'json'
        });
    jQuery("#jqGrid").jqGrid('navGrid', '#pag', {
        edit: true,
        add: true,
        del: true
    })
    });
