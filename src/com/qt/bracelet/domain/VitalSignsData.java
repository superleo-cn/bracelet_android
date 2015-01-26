package com.qt.bracelet.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.qt.bracelet.common.QTApp;
import com.sun.mail.util.QDecoderStream;

/** 
* @ClassName: VitalSignsData 
* @Description: 生命体征数据表 
* @author rw 
* @date 2015-1-22 下午4:20:27 
*  
*/ 
@Table(name = "tb_vitalsigns_data")
public class VitalSignsData extends Model {

	@Column(name = "vs_id")
	public String vsId;

	@Column(name = "motion_state")
	public String motionState;

	@Column(name = "pulse_state")
	public String pulseState;
	
	@Column(name = "temperature")
	public String temperature;

	@Column(name = "bracelet_id")
	public String braceletId;

	@Column(name = "createDate")
	public String createDate;

	@Override
	public String toString() {
		return "VitalSignsData [vsId=" + vsId + ", motionState=" + motionState
				+ ", pulseState=" + pulseState + ", temperature=" + temperature
				+ ", braceletId=" + braceletId + ", createDate=" + createDate
				+ "]";
	}

	/**
	 * 返回食物订单列表 50 条
	 * 
	 * @param status
	 * @return
	 */
	public static List<VitalSignsData> queryListByStatus(int size) {
		return new Select().from(VitalSignsData.class).limit("0, " + size).execute();
	}

	/**
	 * 返回全部生命体征数据列表
	 * 
	 * @return
	 */
	public static List<VitalSignsData> queryAllList() {
		return new Select().from(VitalSignsData.class).execute();
	}

	/**
	 * 保存食物订单
	 * 
	 * @param bean
	 * @param myApp
	 * @param is_foc
	 */
//	public static void save(VitalSignsData bean, QTApp myApp) {
//		if (StringUtils.isNotEmpty(bean.getId()) && !StringUtils.equals(bean.getFood_id(), "0")) {
//			FoodOrder food_order = new FoodOrder();
//			food_order.status = Constants.DB_FAILED;// 是否成功 1是 0否
//			food_order.shopId = myApp.getShopId();// 店idmyApp.getShopid()
//			if(StringUtils.isNotEmpty(tableId.trim())){
//				food_order.orderId = tableId;
//			}else{
//				food_order.orderId = SystemHelper.getUuid();
//			}
//			food_order.totalPackage = String.valueOf(bean.getDabao_price());// 打包钱数
//			food_order.discount = String.valueOf(bean.getDazhe_price()); // 打折钱数
//			food_order.userId = myApp.getUserId();// 用户id
//			double totalRetailPrice = Double.parseDouble(bean.getFood_price()) * Integer.parseInt(bean.getFood_num()) - bean.getDazhe_price() + bean.getDabao_price();
//			if (is_foc) {
//				food_order.foc = Constants.FOC_YES;// 是否免费 1是 0否
//				totalRetailPrice = Constants.DEFAULT_PRICE_NUM_INT;
//			} else {
//				food_order.foc = Constants.FOC_NO;// 是否免费 1是 0否
//				food_order.gstCharge = bean.getGst_charge();
//				food_order.serviceCharge = bean.getService_charge();
//			}
//			food_order.retailPrice = totalRetailPrice;// 收钱数
//			food_order.foodId = bean.getFood_id();// 食物id
//			food_order.quantity = bean.getFood_num();// 数量
//			food_order.orderType = orderType;
//			food_order.flag = flag;
//			food_order.attributesID = bean.getAttributesID();// 属性ID
//			food_order.attributesContext = bean.getAttributesContext();// 属性名字
//			food_order.date = DateUtils.dateToStr(new Date(), DateUtils.YYYY_MM_DD_HH_MM_SS);
//			food_order.save();
//		}
//	}

}
