import javax.inject.Inject
import play.api.http.HttpFilters
import play.filters.cors.CORSFilter
import play.filters.csrf.CSRFFilter
import play.mvc.EssentialFilter
class Filters @Inject() (corsFilter: CORSFilter, csrfFilter: CSRFFilter) extends HttpFilters {

  def filters = Seq(corsFilter, csrfFilter)

}