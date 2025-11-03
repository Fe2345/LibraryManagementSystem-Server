package cn.edu.bjut.librarymanagementsystem.dto;

public record ModifyPwdRequest (String loginName, String email,String newPwd, String ConfirmPwd) {
}
