package com.demo.springboot.entity;

/**
 * @author luyuexin
 * 组织机构表
 *
 */
public class Zzjg {
	
	private   String  JGID		;//机构ID
	private   String  JGDM		;//组织机构代码
	private   String  JGMC		;//机构名称
	private   String  JGJC1		;//机构简称1
	private   String  JGJC2		;//机构简称2
	private   String  JGJC3		;//机构简称3
	private   String  JGJC4		;//机构简称4
	private   String  DWDZ		;//单位地址
	private   String  YZBM		;//邮政编码
	private   Long  PXBZ1		;//	排序标志1
	private   Long  PXBZ2		;//	排序标志2
	private   Long  PXBZ3		;//	排序标志3
	private   Long  PXBZ4		;//	排序标志4
	private   String  DWLXRXM	;//单位联系人姓名
	private   String  LXDH		;//联系电话
	private   Long  JGLX		;//机构类型 0、通讯单位 1、接警单位 2、处警单位 3、联动单位
	private   Long  JGLB		;//机构类别与单位类别表对应
	private   String  YWMC		;//机构类别业务名称
	private   Long  MAPX		;//	在电子地图上的X位置                                          
	private   Long  MAPY		;//	在电子地图上的Y位置                                          
	private   String  CTI		;//CTI设置，根据协议格式的一个串，供调度用的电话，传真，打印机等
	private   Long  DWZLXZT		;//处警单位在离线状态 1:在线  2：离线
	private   Long  SCBZ		;//0 删除标志为1表示已经删除
	private   String  XZQH		;//行政区划
	private   String  NBLXDH	;//内部联系电话
	private   String  HBMDQH	;//黑白名单区号
	private   Long  FXJB		;//分析级别（供警情分析模块函数fun_tjfx使用）
	public String getJGID() {
		return JGID;
	}
	public void setJGID(String jGID) {
		JGID = jGID;
	}
	public String getJGDM() {
		return JGDM;
	}
	public void setJGDM(String jGDM) {
		JGDM = jGDM;
	}
	public String getJGMC() {
		return JGMC;
	}
	public void setJGMC(String jGMC) {
		JGMC = jGMC;
	}
	public String getJGJC1() {
		return JGJC1;
	}
	public void setJGJC1(String jGJC1) {
		JGJC1 = jGJC1;
	}
	public String getJGJC2() {
		return JGJC2;
	}
	public void setJGJC2(String jGJC2) {
		JGJC2 = jGJC2;
	}
	public String getJGJC3() {
		return JGJC3;
	}
	public void setJGJC3(String jGJC3) {
		JGJC3 = jGJC3;
	}
	public String getJGJC4() {
		return JGJC4;
	}
	public void setJGJC4(String jGJC4) {
		JGJC4 = jGJC4;
	}
	public String getDWDZ() {
		return DWDZ;
	}
	public void setDWDZ(String dWDZ) {
		DWDZ = dWDZ;
	}
	public String getYZBM() {
		return YZBM;
	}
	public void setYZBM(String yZBM) {
		YZBM = yZBM;
	}
	public Long getPXBZ1() {
		return PXBZ1;
	}
	public void setPXBZ1(Long pXBZ1) {
		PXBZ1 = pXBZ1;
	}
	public Long getPXBZ2() {
		return PXBZ2;
	}
	public void setPXBZ2(Long pXBZ2) {
		PXBZ2 = pXBZ2;
	}
	public Long getPXBZ3() {
		return PXBZ3;
	}
	public void setPXBZ3(Long pXBZ3) {
		PXBZ3 = pXBZ3;
	}
	public Long getPXBZ4() {
		return PXBZ4;
	}
	public void setPXBZ4(Long pXBZ4) {
		PXBZ4 = pXBZ4;
	}
	public String getDWLXRXM() {
		return DWLXRXM;
	}
	public void setDWLXRXM(String dWLXRXM) {
		DWLXRXM = dWLXRXM;
	}
	public String getLXDH() {
		return LXDH;
	}
	public void setLXDH(String lXDH) {
		LXDH = lXDH;
	}
	public Long getJGLX() {
		return JGLX;
	}
	public void setJGLX(Long jGLX) {
		JGLX = jGLX;
	}
	public Long getJGLB() {
		return JGLB;
	}
	public void setJGLB(Long jGLB) {
		JGLB = jGLB;
	}
	public String getYWMC() {
		return YWMC;
	}
	public void setYWMC(String yWMC) {
		YWMC = yWMC;
	}
	public Long getMAPX() {
		return MAPX;
	}
	public void setMAPX(Long mAPX) {
		MAPX = mAPX;
	}
	public Long getMAPY() {
		return MAPY;
	}
	public void setMAPY(Long mAPY) {
		MAPY = mAPY;
	}
	public String getCTI() {
		return CTI;
	}
	public void setCTI(String cTI) {
		CTI = cTI;
	}
	public Long getDWZLXZT() {
		return DWZLXZT;
	}
	public void setDWZLXZT(Long dWZLXZT) {
		DWZLXZT = dWZLXZT;
	}
	public Long getSCBZ() {
		return SCBZ;
	}
	public void setSCBZ(Long sCBZ) {
		SCBZ = sCBZ;
	}
	public String getXZQH() {
		return XZQH;
	}
	public void setXZQH(String xZQH) {
		XZQH = xZQH;
	}
	public String getNBLXDH() {
		return NBLXDH;
	}
	public void setNBLXDH(String nBLXDH) {
		NBLXDH = nBLXDH;
	}
	public String getHBMDQH() {
		return HBMDQH;
	}
	public void setHBMDQH(String hBMDQH) {
		HBMDQH = hBMDQH;
	}
	public Long getFXJB() {
		return FXJB;
	}
	public void setFXJB(Long fXJB) {
		FXJB = fXJB;
	}
	


}
