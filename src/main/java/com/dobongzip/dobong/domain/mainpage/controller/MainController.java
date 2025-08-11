package com.dobongzip.dobong.domain.mainpage.controller;

import com.dobongzip.dobong.domain.mainpage.dto.request.EventSearchRequest;
import com.dobongzip.dobong.domain.mainpage.dto.response.EventDto;
import com.dobongzip.dobong.domain.mainpage.service.MainService;
import com.dobongzip.dobong.global.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "메인페이지", description = "메인페이지 조회 API")
@RestController
@RequestMapping("/api/mainpage")
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @Operation(
            summary = "도봉구 행사 조회 (오늘 기본)",
            description = "서울 문화행사 전수 데이터에서 '오늘 포함'되는 이벤트만 추려서, 자치구가 도봉구인 항목만 반환합니다. "
                    + "date 파라미터가 없으면 서버 기준(KST) 오늘 날짜를 사용합니다."
    )
    @GetMapping("/dobong")
    public ResponseEntity<CommonResponse<List<EventDto>>> getDobong(
            @RequestParam(required = false) String date
    ) {
        EventSearchRequest req = new EventSearchRequest();
        req.setDate(date);
        return ResponseEntity.ok(CommonResponse.onSuccess(mainService.getDobongToday(req)));
    }

}
