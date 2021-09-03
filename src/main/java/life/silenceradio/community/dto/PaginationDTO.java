package life.silenceradio.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        totalPage = (totalCount + size - 1) / size;

        page = page < 1 ? 1 : page;
        page = page > totalPage ? totalPage : page;

        this.page = page;
        int pagesBegin = Math.max(page - 3, 1), pagesEnd = Math.min(page + 3, totalPage);
        for (int i = pagesBegin; i <= pagesEnd; i++) {
            pages.add(i);
        }



        showPrevious = page != 1;
        showNext = page != totalPage;
        showFirstPage = !pages.contains(1);
        showEndPage = !pages.contains(totalPage);

    }
}
