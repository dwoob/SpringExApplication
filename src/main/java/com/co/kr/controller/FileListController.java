@Slf4j
@Controller
public class FileListController {
	
	@Autowired
	private UploadService uploadService;

	
	@PostMapping(value = "upload")
	public ModelAndView bdUpload(FileListVO fileListVO, MultipartHttpServletRequest request, HttpServletRequest httpReq) throws IOException, ParseException {
		
		ModelAndView mav = new ModelAndView();
		int bdSeq = uploadService.fileProcess(fileListVO, request, httpReq);
		fileListVO.setContent(""); //초기화
		fileListVO.setTitle(""); //초기화
		
		// 화면에서 넘어올때는 bdSeq String이라 string으로 변환해서 넣어즘
		mav = bdSelectOneCall(fileListVO, String.valueOf(bdSeq),request);
		mav.setViewName("board/boardList.html");
		return mav;
		
	}

}