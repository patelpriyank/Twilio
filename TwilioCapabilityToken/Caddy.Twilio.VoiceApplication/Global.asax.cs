using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Optimization;
using System.Web.Routing;

namespace Caddy.Twilio.VoiceApplication
{
    public class MvcApplication : System.Web.HttpApplication
    {
        protected void Application_Start()
        {
            AreaRegistration.RegisterAllAreas();
            FilterConfig.RegisterGlobalFilters(GlobalFilters.Filters);
            RouteConfig.RegisterRoutes(RouteTable.Routes);
            BundleConfig.RegisterBundles(BundleTable.Bundles);
        }

        /*protected void Application_AcquireRequestState(Object sender, EventArgs e)
        {
            if (Session.IsNewSession)
            {
                bool isCshtmlRequest = HttpContext.Current.Request.Url.AbsolutePath.Contains(".cshtml");
                if (isCshtmlRequest)
                {
                    Server.TransferRequest(HttpContext.Current.Request.Url.AbsolutePath);
                   // Server.TransferRequest(HttpContext.Current.Request.Url.AbsolutePath);
                }
            }
        }*/
    }
}
