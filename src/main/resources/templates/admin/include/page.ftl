<div class="pages_num dataTables_wrapper">
    <style type="text/css">
        .pages_num.dataTables_wrapper{
            font-size: 0;
        }
        .pages_num.dataTables_wrapper a{
            font-size: 14px;
        }
        .pages_num.dataTables_wrapper .dataTables_paginate .paginate_button.disabled {
            color: #999;
            background: #eee;
        }

        .pages_num.dataTables_wrapper .dataTables_length {
            padding-bottom: 0;
            padding-top: 8px;
            margin-left: 20px;
        }

        .pages_num .paginate_ellipsis {
            position: relative;
            top: 7px;
            margin: 0 3px 0 6px;
            color: #666;
            cursor: default;
            text-decoration: none;
        }
    </style>
    <#if pageInfo?exists>
        <div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">当前显示 ${pageInfo.startRow!} 到 ${pageInfo.endRow!} ，共 ${pageInfo.total!} 条</div>
        <div class="dataTables_length" id="DataTables_Table_0_length"><label>每页显示
            <select name="DataTables_Table_0_length" pageSize="true" aria-controls="DataTables_Table_0" class="select">
                <option value="15" <#if pageInfo.pageSize == 15>selected</#if>>15</option>
                <option value="25" <#if pageInfo.pageSize == 25>selected</#if>>25</option>
                <option value="50" <#if pageInfo.pageSize == 50>selected</#if>>50</option>
                <option value="100" <#if pageInfo.pageSize == 100>selected</#if>>100</option>
            </select> 条</label>
        </div>
        <div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate">
            <a class="paginate_button arrow_btn prev <#if pageInfo.pageNum == 1>disabled</#if>" id="DataTables_Table_0_previous" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0">上一页</a>
            <span class="paginate_pages_wrap">
                <#if (pageInfo.pageNum + pageInfo.pages - 1) < 10>
                    <#assign pageMax=pageInfo.pages>
                <#else>
                    <#assign pageMax= 10 + pageInfo.pageNum - 1>
                </#if>

                <#if pageInfo.pages < 10>
                    <#assign pageMin=1>
                <#else>
                    <#assign pageMin= pageInfo.pageNum>
                </#if>

                <#list pageMin..pageMax as i>
                    <a class="paginate_button page_link <#if i == pageInfo.pageNum>current</#if>" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0">${i}</a>
                </#list>
                <#if ((pageInfo.pageNum + pageInfo.pages - 1) > 10)>
                    <a class="paginate_ellipsis">...</a>
                </#if>
            </span>
            <a class="paginate_button arrow_btn next <#if pageInfo.pageNum == pageInfo.pages>disabled</#if>" id="DataTables_Table_0_next" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0">下一页</a>
        </div>
    </#if>
    <script type="text/javascript">
        window.onload = function () {
            //点击页码
            $('.paginate_pages_wrap').delegate('.paginate_button.page_link','click',function () {
                $(this).addClass('current').siblings().removeClass('current');
                toNewPage(this);
                // updatePrevNextBtnState();
            });

            // 绑定页码下拉框change事件
            $("select[pageSize='true']").change(function () {
                var dom = $('.paginate_pages_wrap.paginate_button.page_link');
                toNewPage(dom);
            });

            //点击上下页按钮
            $('.paginate_button.arrow_btn').click(function () {
                if (!$(this).hasClass('disabled')) {
                    var pageNum;
                    if ($(this).hasClass('next')) {
                        pageNum = ${pageInfo.pageNum} + 1;
                    } else {
                        pageNum = ${pageInfo.pageNum} - 1;
                    }
                    toNewPage(null, pageNum);
                }
            });
        }

        function toNewPage(dom, pageNum){
            if (!pageNum){
                var pageNum = $(dom).text();
            }
            var pageSize = $("select[pageSize='true']").val();
            var form = $("form[searchCond='true']");
            form.append("<input type='hidden' name='pageNum' value='" + pageNum + "'/>");
            form.append("<input type='hidden' name='pageSize' value='" + pageSize + "'/>");
            form.submit();
        }
    </script>
</div>