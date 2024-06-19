package com.meogo.meogo_backend.domain.community.article.dto;

import jakarta.validation.constraints.Size;

import java.util.List;

public record ArticleCreateRequest(
        @Size(min = 1, max = 20, message = "제목은 1글자 이상 20글자 이하로 입력해주세요")
        String title,
        @Size(min = 1, max = 300, message = "내용은 1글자 이상 300글자 이하로 입력해주세요")
        String content,
        String schoolName,
        List<String> tags
) {
}
