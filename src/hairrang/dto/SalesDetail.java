package hairrang.dto;

/* 주문 상세 */
public class SalesDetail {

	private int detailNo;
	private Sales salesNo;
	private Hair hairNo;
	
	public SalesDetail() {
	}

	public SalesDetail(int detailNo) {
		this.detailNo = detailNo;
	}
	
	public SalesDetail(int detailNo, Sales salesNo, Hair hairNo) {
		this.detailNo = detailNo;
		this.salesNo = salesNo;
		this.hairNo = hairNo;
	}

	public int getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(int detailNo) {
		this.detailNo = detailNo;
	}

	public Sales getSalesNo() {
		return salesNo;
	}

	public void setSalesNo(Sales salesNo) {
		this.salesNo = salesNo;
	}

	public Hair getHairNo() {
		return hairNo;
	}

	public void setHairNo(Hair hairNo) {
		this.hairNo = hairNo;
	}

	@Override
	public String toString() {
		return String.format("SalesDetail [detailNo=%s, salesNo=%s, hairNo=%s]", detailNo, salesNo, hairNo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + detailNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this.detailNo == ((SalesDetail) obj).detailNo;
	}

	
}
