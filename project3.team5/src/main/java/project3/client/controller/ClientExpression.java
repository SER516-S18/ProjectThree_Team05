package project3.client.controller;

import project3.model.ExpressiveModel;

public class ClientExpression {

 ExpressiveModel expressiveModel;
 
 
 public ExpressiveModel getExpressiveModel() {
	return expressiveModel;
}

public void setExpressiveModel(ExpressiveModel expressiveModel) {
	this.expressiveModel = expressiveModel;
}

public ClientExpression() {
	expressiveModel = new ExpressiveModel();
	expressiveModel.setGifLabel("res/laugh.png");
 }

 public String getExpression(ExpressiveModel expressiveModel) {
	 if(expressiveModel.isAutoReset()) {
	 
	 if(expressiveModel.getBlink()!=0) {
		 return "blink.gif";
	 }
	 else if(expressiveModel.getRightWlink()!=0) {
		 return "rightwink.gif";
	 }
	 else if(expressiveModel.getLeftWink()!=0) {
		 return "leftwink.gif";
	 }
	 else if(expressiveModel.getLookLeft()!=0) {
		 return "lookleft.gif";
	 }
	 else if(expressiveModel.getLookRight()!=0) {
		 return "lookright.gif";
	 }
	 else if(expressiveModel.getFurrowBrow()!=0) {
		 return "furrowbrow.gif";
	 }
	 else if(expressiveModel.getRaiseBrow()!=0) {
		 return "raisebrow.gif";
	 }
	 else if(expressiveModel.getSmile()!=0) {
		 return "smile.gif";
	 }
	 else if(expressiveModel.getClench()!=0) {
		 return "clench.gif";
	 }
	 else if(expressiveModel.getSmirkLeft()!=0) {
		 return "leftsmirk.gif";
	 }
	 else if(expressiveModel.getSmirkRight()!=0) {
		 return "rightsmirk.gif";
	 }
	 else if(expressiveModel.getLaugh()!=0) {
		 return "laugh.gif";
	 }
	 }
	 else {
		 if(expressiveModel.getBlink()!=0) {
			 return "blinkclose.png";
		 }
		 else if(expressiveModel.getRightWlink()!=0) {
			 return "wink.png";
		 }
		 else if(expressiveModel.getLeftWink()!=0) {
			 return "leftwink.png";
		 }
		 else if(expressiveModel.getLookLeft()!=0) {
			 return "lookleft.png";
		 }
		 else if(expressiveModel.getLookRight()!=0) {
			 return "lookright.png";
		 }
		 else if(expressiveModel.getFurrowBrow()!=0) {
			 return "furrowbrow.png";
		 }
		 else if(expressiveModel.getRaiseBrow()!=0) {
			 return "highbrow.png";
		 }
		 else if(expressiveModel.getSmile()!=0) {
			 return "smile.png";
		 }
		 else if(expressiveModel.getClench()!=0) {
			 return "clench.png";
		 }
		 else if(expressiveModel.getSmirkLeft()!=0) {
			 return "leftsmirk.png";
		 }
		 else if(expressiveModel.getSmirkRight()!=0) {
			 return "rightsmirk.png";
		 }
		 else if(expressiveModel.getLaugh()!=0) {
			 return "laughing.png";
		 } 
	 }
	
	return null;
		 
 }
}
