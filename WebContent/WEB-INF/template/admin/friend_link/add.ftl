<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>${message("admin.friendLink.add")} - Powered By SHOP++</title>
<meta name="author" content="SHOP++ Team" />
<meta name="copyright" content="SHOP++" />
<link href="${base}/resources/admin/css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/resources/admin/js/jquery.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/jquery.validate.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/common.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/input.js"></script>
<script type="text/javascript">
$().ready(function() {

	var $inputForm = $("#inputForm");
	var $type = $("#type");
	var $logo = $("#logo");
	var $browserButton = $("#browserButton");
	
	[@flash_message /]
	
	$browserButton.browser();
	
	$type.change(function() {
		if ($(this).val() == "text") {
			$logo.val("").prop("disabled", true);
			$browserButton.prop("disabled", true);
		} else {
			$logo.prop("disabled", false);
			$browserButton.prop("disabled", false);
		}
	});
	
	// 表单验证
	$inputForm.validate({
		rules: {
			name: "required",
			url: "required",
			logo: "required",
			order: "digits"
		}
	});
	
});
</script>
</head>
<body>
	<div class="path">
		<a href="${base}/admin/common/index.jhtml">${message("admin.path.index")}</a> &raquo; ${message("admin.friendLink.add")}
	</div>
	<form id="inputForm" action="save.jhtml" method="post">
		<table class="input">
			<tr>
				<th>
					<span class="requiredField">*</span>${message("FriendLink.name")}:
				</th>
				<td>
					<input type="text" name="name" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					${message("FriendLink.type")}:
				</th>
				<td>
					<select id="type" name="type">
						[#list types as type]
							<option value="${type}">${message("FriendLink.Type." + type)}</option>
						[/#list]
					</select>
				</td>
			</tr>
			<tr>
				<th>
					${message("FriendLink.logo")}:
				</th>
				<td>
					<span class="fieldSet">
						<input type="text" id="logo" name="logo" class="text" maxlength="200" disabled="disabled" />
						<input type="button" id="browserButton" class="button" value="${message("admin.browser.select")}" disabled="disabled" />
					</span>
				</td>
			</tr>
			<tr>
				<th>
					<span class="requiredField">*</span>${message("FriendLink.url")}:
				</th>
				<td>
					<input type="text" name="url" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					${message("admin.common.order")}:
				</th>
				<td>
					<input type="text" name="order" class="text" maxlength="9" />
				</td>
			</tr>
			<tr>
				<th>
					&nbsp;
				</th>
				<td>
					<input type="submit" class="button" value="${message("admin.common.submit")}" />
					<input type="button" id="backButton" class="button" value="${message("admin.common.back")}" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>