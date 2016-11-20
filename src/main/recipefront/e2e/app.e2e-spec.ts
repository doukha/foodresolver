import { RecipefrontPage } from './app.po';

describe('recipefront App', function() {
  let page: RecipefrontPage;

  beforeEach(() => {
    page = new RecipefrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
