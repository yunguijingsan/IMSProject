package com.shine.entity.ims.ext;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
//import oracle.jbo.domain.Date;

public class Functions  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer FunctionId;
    private String FunctionName;
    private String UserFunctionName;
    private String FunctionDescription;
    private Integer ApplicationId;
    private String Parameters;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
    private Date CreationDate;
    private String CreatedBy;
    private Date LastUpdateDate;
    private String LastUpdatedBy;
    private String LastUpdateLogin;
    private String Type;
    private String WebHostName;
    private String WebAgentName;
    private String WebHtmlCall;
    private String WebSecured;
    private String WebIcon;
    private Integer ObjectId;
    private Integer RegionApplicationId;
    private String RegionCode;
    private String MaintenanceModeSupport;
    private String ContextDependence;
    private String IrepMethodName;
    private Integer IrepOverloadSequence;
    private String IrepScope;
    private String IrepLifecycle;
    private String IrepDescription;
    private String IrepCompatibility;
    private String IrepInboundXmlDescription;
    private String IrepOutboundXmlDescription;
    private String IrepSynchro;
    private String IrepDirection;
    private String IrepAssocFunctionName;
    private Long IrepClassId;
    private String IrepSchemaValidationFlag;
    private String ZdEditionName;
    private Integer DocumentIconId;
    private String MobileEnabledFlag;
    private String RestPath;
    private String PcIcon;
    private String UrlPath;
    private String ApplicationShortName;
    private String IconPath;
    private Integer UserId;
    private Integer MenuId;
    
    private Integer EntrySequence;
    private String Prompt;
    private String GrantFlag;
    
    private String applicationName;
    private String typeName;


    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationName() {
        return applicationName;
    }


    public void setGrantFlag(String GrantFlag) {
        this.GrantFlag = GrantFlag;
    }

    public String getGrantFlag() {
        return GrantFlag;
    }


    public void setEntrySequence(Integer EntrySequence) {
        this.EntrySequence = EntrySequence;
    }

    public Integer getEntrySequence() {
        return EntrySequence;
    }

    public void setPrompt(String Prompt) {
        this.Prompt = Prompt;
    }

    public String getPrompt() {
        return Prompt;
    }

    public void setMenuId(Integer MenuId) {
        this.MenuId = MenuId;
    }

    public Integer getMenuId() {
        return MenuId;
    }

    //菜单 是否拥有功能
    private String EnabledFlag;

    public void setEnabledFlag(String EnabledFlag) {
        this.EnabledFlag = EnabledFlag;
    }

    public String getEnabledFlag() {
        return EnabledFlag;
    }


    public Functions() {
        super();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Functions)) {
            return false;
        }
        final Functions other = (Functions) object;
        if (!(FunctionId == null ? other.FunctionId == null : FunctionId.equals(other.FunctionId))) {
            return false;
        }
        return true;
    }

    public void setApplicationShortName(String ApplicationShortName) {
        this.ApplicationShortName = ApplicationShortName;
    }

    public String getApplicationShortName() {
        return ApplicationShortName;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((FunctionId == null) ? 0 : FunctionId.hashCode());
        return result;
    }

    public void setPcIcon(String PcIcon){
        this.PcIcon = PcIcon;
    }
    public String getPcIcon(){
        return PcIcon;    
    }    
    public void setUrlPath(String UrlPath){
        this.UrlPath = UrlPath;
    }
    public String getUrlPath(){
        return UrlPath;    
    }  

    public void setFunctionId(Integer FunctionId) {
        this.FunctionId = FunctionId;
    }

    public Integer getFunctionId() {
        return FunctionId;
    }

    public void setFunctionName(String FunctionName) {
        this.FunctionName = FunctionName;
    }

    public String getFunctionName() {
        return FunctionName;
    }

    public void setIconPath(String IconPath) {
        this.IconPath = IconPath;
    }

    public String getIconPath() {
        return IconPath;
    }

    public void setUserFunctionName(String UserFunctionName) {
        this.UserFunctionName = UserFunctionName;
    }

    public String getUserFunctionName() {
        return UserFunctionName;
    }

    public void setFunctionDescription(String FunctionDescription) {
        this.FunctionDescription = FunctionDescription;
    }

    public String getFunctionDescription() {
        return FunctionDescription;
    }

    public void setApplicationId(Integer ApplicationId) {
        this.ApplicationId = ApplicationId;
    }

    public Integer getApplicationId() {
        return ApplicationId;
    }

    public void setParameters(String Parameters) {
        this.Parameters = Parameters;
    }

    public String getParameters() {
        return Parameters;
    }
    
    public void setCreationDate(Date CreationDate) {
        this.CreationDate = CreationDate;
    }
    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreatedBy(String CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setLastUpdateDate(Date LastUpdateDate) {
        this.LastUpdateDate = LastUpdateDate;
    }
    public Date getLastUpdateDate() {
        return LastUpdateDate;
    }

    public void setLastUpdatedBy(String LastUpdatedBy) {
        this.LastUpdatedBy = LastUpdatedBy;
    }

    public String getLastUpdatedBy() {
        return LastUpdatedBy;
    }

    public void setLastUpdateLogin(String LastUpdateLogin) {
        this.LastUpdateLogin = LastUpdateLogin;
    }

    public String getLastUpdateLogin() {
        return LastUpdateLogin;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getType() {
        return Type;
    }

    public void setWebHostName(String WebHostName) {
        this.WebHostName = WebHostName;
    }

    public String getWebHostName() {
        return WebHostName;
    }

    public void setWebAgentName(String WebAgentName) {
        this.WebAgentName = WebAgentName;
    }

    public String getWebAgentName() {
        return WebAgentName;
    }

    public void setWebHtmlCall(String WebHtmlCall) {
        this.WebHtmlCall = WebHtmlCall;
    }

    public String getWebHtmlCall() {
        return WebHtmlCall;
    }

    public void setWebSecured(String WebSecured) {
        this.WebSecured = WebSecured;
    }

    public String getWebSecured() {
        return WebSecured;
    }

    public void setWebIcon(String WebIcon) {
        this.WebIcon = WebIcon;
    }

    public String getWebIcon() {
        return WebIcon;
    }

    public void setObjectId(Integer ObjectId) {
        this.ObjectId = ObjectId;
    }

    public Integer getObjectId() {
        return ObjectId;
    }

    public void setRegionApplicationId(Integer RegionApplicationId) {
        this.RegionApplicationId = RegionApplicationId;
    }

    public Integer getRegionApplicationId() {
        return RegionApplicationId;
    }

    public void setRegionCode(String RegionCode) {
        this.RegionCode = RegionCode;
    }

    public String getRegionCode() {
        return RegionCode;
    }

    public void setMaintenanceModeSupport(String MaintenanceModeSupport) {
        this.MaintenanceModeSupport = MaintenanceModeSupport;
    }

    public String getMaintenanceModeSupport() {
        return MaintenanceModeSupport;
    }

    public void setContextDependence(String ContextDependence) {
        this.ContextDependence = ContextDependence;
    }

    public String getContextDependence() {
        return ContextDependence;
    }

    public void setIrepMethodName(String IrepMethodName) {
        this.IrepMethodName = IrepMethodName;
    }

    public String getIrepMethodName() {
        return IrepMethodName;
    }

    public void setIrepOverloadSequence(Integer IrepOverloadSequence) {
        this.IrepOverloadSequence = IrepOverloadSequence;
    }

    public Integer getIrepOverloadSequence() {
        return IrepOverloadSequence;
    }

    public void setIrepScope(String IrepScope) {
        this.IrepScope = IrepScope;
    }

    public String getIrepScope() {
        return IrepScope;
    }

    public void setIrepLifecycle(String IrepLifecycle) {
        this.IrepLifecycle = IrepLifecycle;
    }

    public String getIrepLifecycle() {
        return IrepLifecycle;
    }

    public void setIrepDescription(String IrepDescription) {
        this.IrepDescription = IrepDescription;
    }

    public String getIrepDescription() {
        return IrepDescription;
    }

    public void setIrepCompatibility(String IrepCompatibility) {
        this.IrepCompatibility = IrepCompatibility;
    }

    public String getIrepCompatibility() {
        return IrepCompatibility;
    }

    public void setIrepInboundXmlDescription(String IrepInboundXmlDescription) {
        this.IrepInboundXmlDescription = IrepInboundXmlDescription;
    }

    public String getIrepInboundXmlDescription() {
        return IrepInboundXmlDescription;
    }

    public void setIrepOutboundXmlDescription(String IrepOutboundXmlDescription) {
        this.IrepOutboundXmlDescription = IrepOutboundXmlDescription;
    }

    public String getIrepOutboundXmlDescription() {
        return IrepOutboundXmlDescription;
    }

    public void setIrepSynchro(String IrepSynchro) {
        this.IrepSynchro = IrepSynchro;
    }

    public String getIrepSynchro() {
        return IrepSynchro;
    }

    public void setIrepDirection(String IrepDirection) {
        this.IrepDirection = IrepDirection;
    }

    public String getIrepDirection() {
        return IrepDirection;
    }

    public void setIrepAssocFunctionName(String IrepAssocFunctionName) {
        this.IrepAssocFunctionName = IrepAssocFunctionName;
    }

    public String getIrepAssocFunctionName() {
        return IrepAssocFunctionName;
    }

    public void setIrepClassId(Long IrepClassId) {
        this.IrepClassId = IrepClassId;
    }

    public Long getIrepClassId() {
        return IrepClassId;
    }

    public void setIrepSchemaValidationFlag(String IrepSchemaValidationFlag) {
        this.IrepSchemaValidationFlag = IrepSchemaValidationFlag;
    }

    public String getIrepSchemaValidationFlag() {
        return IrepSchemaValidationFlag;
    }

    public void setZdEditionName(String ZdEditionName) {
        this.ZdEditionName = ZdEditionName;
    }

    public String getZdEditionName() {
        return ZdEditionName;
    }

    public void setDocumentIconId(Integer DocumentIconId) {
        this.DocumentIconId = DocumentIconId;
    }

    public Integer getDocumentIconId() {
        return DocumentIconId;
    }

    public void setMobileEnabledFlag(String MobileEnabledFlag) {
        this.MobileEnabledFlag = MobileEnabledFlag;
    }

    public String getMobileEnabledFlag() {
        return MobileEnabledFlag;
    }

    public void setRestPath(String RestPath) {
        this.RestPath = RestPath;
    }

    public String getRestPath() {
        return RestPath;
    }

    public void setUserId(Integer UserId) {
        this.UserId = UserId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
