package com.masoudjafari.taskjava.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("summary")
	private String summary;

	@SerializedName("conditional_flag")
	private String conditionalFlag;

	@SerializedName("flag")
	private String flag;

	@SerializedName("year")
	private int year;

	@SerializedName("page_title")
	private String pageTitle;

	@SerializedName("imdb_rank_percent")
	private int imdbRankPercent;

	@SerializedName("alter_cover_image")
	private AlterCoverImage alterCoverImage;

	@SerializedName("short_id")
	private String shortId;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private String type;

	@SerializedName("duration")
	private String duration;

	@SerializedName("rate")
	private double rate;

	@SerializedName("original_name")
	private String originalName;

	@SerializedName("cover_image")
	private CoverImage coverImage;

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	@SerializedName("id")
	private String id;

	@SerializedName("age_restriction")
	private String ageRestriction;

	@SerializedName("slug")
	private String slug;

	@SerializedName("status")
	private String status;

	@SerializedName("poster_image")
	private PosterImage posterImage;

	@SerializedName("logo_image")
	private LogoImage logoImage;

	public String getSummary(){
		return summary;
	}

	public String getConditionalFlag(){
		return conditionalFlag;
	}

	public String getFlag(){
		return flag;
	}

	public int getYear(){
		return year;
	}

	public String getPageTitle(){
		return pageTitle;
	}

	public int getImdbRankPercent(){
		return imdbRankPercent;
	}

	public AlterCoverImage getAlterCoverImage(){
		return alterCoverImage;
	}

	public String getShortId(){
		return shortId;
	}

	public String getTitle(){
		return title;
	}

	public String getType(){
		return type;
	}

	public String getDuration(){
		return duration;
	}

	public double getRate(){
		return rate;
	}

	public String getOriginalName(){
		return originalName;
	}

	public CoverImage getCoverImage(){
		return coverImage;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	public String getId(){
		return id;
	}

	public String getAgeRestriction(){
		return ageRestriction;
	}

	public String getSlug(){
		return slug;
	}

	public String getStatus(){
		return status;
	}

	public PosterImage getPosterImage(){
		return posterImage;
	}

	public LogoImage getLogoImage(){
		return logoImage;
	}
}